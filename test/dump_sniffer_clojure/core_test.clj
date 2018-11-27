(ns dump-sniffer-clojure.core-test
  (:require [clojure.test :refer :all]
            [dump-sniffer-clojure.core :refer :all]))

(deftest dump-sniffer-table-names
  (testing "outputs table names"
    (is (= (dump-sniffer-table-names "test/fixtures/simple.sql")
           ["customers" "employees" "offices" "orderdetails" "orders" "payments" "productlines" "products"]))))
