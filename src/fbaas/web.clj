(ns fbaas.web
  (:require [org.httpkit.server :as s]
            [clojure.edn :as edn]
            [compojure.core :refer [defroutes GET]]
            [clojure.data.json :as json]
            [fbaas.core :as c]))

(defn index [_]
  {:status 200
   :body "<h1>Welcome to FizzBuzz as a service! Navigate to /fb/:num to get a fizzbuzzable number</h1>"
   :headers {"Content-Type" "text/html"}})

(defn fizzbuzz [req]
  (let [params (:params req)
        num (edn/read-string (:num params))
        result (c/fizz-buzz num)
        body (json/write-str {:value result :input (:num params)})]
    {:status 200
     :body body
     :headers {"Content-Type" "application/json"}}))

(defroutes routes
  (GET "/" [] index)
  (GET "/fb/:num" [] fizzbuzz))

(defn -main []
  (println "Starting FizzBuzz As A Service (fbaas) server")
  (s/run-server routes {:port 8080}))
