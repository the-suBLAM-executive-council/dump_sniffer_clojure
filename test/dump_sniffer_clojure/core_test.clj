(ns dump-sniffer-clojure.core-test
  (:require [clojure.test :refer :all]
            [dump-sniffer-clojure.core :refer :all]))

(def table-structure-output
  (clojure.string/join
    "\n"
    ["DROP TABLE IF EXISTS `customers`;"
     "CREATE TABLE `customers` ("
     "  `customerNumber` int(11) NOT NULL,"
     "  `customerName` varchar(50) NOT NULL,"
     ") ENGINE=InnoDB DEFAULT CHARSET=latin1;"]))

(deftest test-main
  (def table-names-output
    (clojure.string/join "\n" ["customers" "employees" "offices" "orderdetails" "orders" "payments" "productlines" "products" ""]))

  (testing "with -t flag"
    (is (= (with-out-str (-main "-t" "test/fixtures/simple.sql"))
           table-names-output)))

  (testing "with --table-names flag"
    (is (= (with-out-str (-main "--table-names" "test/fixtures/simple.sql"))
           table-names-output)))

  (testing "with -s flag"
    (is (= (with-out-str (-main "-s" "test/fixtures/single_table_with_data.sql"))
           table-structure-output)))

  (testing "with --structure-only flag"
    (is (= (with-out-str (-main "-s" "test/fixtures/single_table_with_data.sql"))
           table-structure-output))))

(deftest test-extract-table-names
  (testing "outputs table names"
    (is (= (extract-table-names "test/fixtures/simple.sql")
           ["customers" "employees" "offices" "orderdetails" "orders" "payments" "productlines" "products"]))))

(deftest test-extract-db-structure
  (testing "outputs db structure"
    (is (= (extract-db-structure "test/fixtures/single_table_with_data.sql")
           table-structure-output))))
