(ns dump-sniffer-clojure.core
  (require [clojure.string :as str])
  (require [clojure.tools.cli :as cli])
  (:gen-class))

(defn dump-sniffer-table-names [fname]
  (->> (slurp fname)
       (re-seq #"(?i)create table `(.*?)`")
       (vec)
       (map last)))

(defn -main
  [& args]
  (let [options (cli/parse-opts args [["-t" "--table-names"]])]
    (if (get-in options [:options :table-names])
      (->> (dump-sniffer-table-names (last args))
           (clojure.string/join "\n")
           println)
      (println "doing nothing"))))
