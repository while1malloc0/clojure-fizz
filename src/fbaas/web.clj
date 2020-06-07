(ns fbaas.web
  (:require [org.httpkit.server :as s]
            [clojure.edn :as edn]
            [compojure.core :refer [defroutes GET]]
            [fbaas.core :as c]))

(defn index [req]
  {:status 200
   :body "<h1>Welcome to FizzBuzz as a service! Navigate to /fb/:num to get a fizzbuzzable number</h1>"
   :headers {"Content-Type" "text/html"}})

(defn fizzbuzz [req]
  (let [num (edn/read-string (:num (:params req)))]
    {:status 200
      :body (c/fizz-buzz num)
      :headers {"Content-Type" "text/html"}}))

(defroutes routes
  (GET "/" [] index)
  (GET "/fb/:num" [] fizzbuzz))

(defn -main []
  (println "Starting FizzBuzz As A Service (fbaas) server")
  (s/run-server routes {:port 8080}))
