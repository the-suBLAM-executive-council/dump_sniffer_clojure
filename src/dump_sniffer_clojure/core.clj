(ns dump-sniffer-clojure.core
  (require [clojure.string :as str])
  (require [clojure.tools.cli :as cli])
  (:gen-class))

(defn extract-table-names [fname]
  (->> (slurp fname)
       (re-seq #"(?i)create table `(.*?)`")
       (vec)
       (map last)))

(defn extract-db-structure [fname]
  (->> (slurp fname)
       (re-seq #"(?is)DROP TABLE .*?;|CREATE TABLE.*?;")
       (vec)
       (clojure.string/join "\n")))

(defn -main
  [& args]
  (let [options (cli/parse-opts args [["-t" "--table-names"] ["-s" "--structure-only"]])]
    (cond
      (get-in options [:options :table-names])
        (->> (extract-table-names (last args))
             (clojure.string/join "\n")
             println)
      (get-in options [:options :structure-only])
        (->> (extract-db-structure (last args))
             (print))
      :else
        (println "doing nothing"))))
