(ns dump-sniffer-clojure.core
  (:gen-class))
  (require '[clojure.string :as str])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn dump-sniffer-table-names [fname]
  (->> (slurp fname)
       (re-seq #"(?i)create table `(.*?)`")
       (vec)
       (map last)))

;(defn dump-sniffer-table-names [fname]
  ;(map
    ;last
    ;(vec
      ;(re-seq
        ;#"(?i)create table `(.*?)`"
        ;(slurp fname)))))
