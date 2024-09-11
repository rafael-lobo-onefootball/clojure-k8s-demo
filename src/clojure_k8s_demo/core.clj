(ns clojure-k8s-demo.core
  (:require [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello from Clojure on Kubernetes!"})

(defn -main [& args]
  (jetty/run-jetty handler {:port 3000}))
