(defproject clojure-k8s-demo "0.1.0-SNAPSHOT"
  :description "Demo Clojure app for Kubernetes"
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.9.5"]
                 [ring/ring-jetty-adapter "1.9.5"]]
  :main ^:skip-aot clojure-k8s-demo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
