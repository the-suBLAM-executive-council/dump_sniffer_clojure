(ns dump-sniffer-clojure.core-test
  (:require [clojure.test :refer :all]
            [dump-sniffer-clojure.core :refer :all]))

(deftest test-main
  (def table-names-output
    (clojure.string/join "\n" ["customers" "employees" "offices" "orderdetails" "orders" "payments" "productlines" "products" ""]))

  (testing "with -t flag"
    (is (= (with-out-str (-main "-t" "test/fixtures/simple.sql"))
           table-names-output)))

  (testing "with --table-names flag"
    (is (= (with-out-str (-main "--table-names" "test/fixtures/simple.sql"))
           table-names-output))))

(deftest test-dump-sniffer-table-names
  (testing "outputs table names"
    (is (= (dump-sniffer-table-names "test/fixtures/simple.sql")
           ["customers" "employees" "offices" "orderdetails" "orders" "payments" "productlines" "products"]))))
