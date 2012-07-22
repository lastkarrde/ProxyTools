(ns website.main
	(:use 		[compojure.core]
				[net.cgrand.enlive-html]
				[ring.middleware reload])

	(:require 	[compojure.route :as route]
			  	[compojure.handler :as handler]
			  	[clj-json.core :as json]))


(deftemplate new-template "new.html"
	[s])

(defroutes main-routes
	(GET "/" [] new-template)

	(route/resources "/")
	(route/not-found "Page not found"))

(def app
	(handler/site main-routes))