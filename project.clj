(defproject dump_sniffer_clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[io.aviso/pretty "0.1.21"]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.aviso/pretty "0.1.21"]
                 [org.clojure/tools.cli "0.4.1"]]
  :main ^:skip-aot dump-sniffer-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
