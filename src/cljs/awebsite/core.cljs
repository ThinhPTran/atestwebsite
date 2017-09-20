(ns awebsite.core
  (:require [reagent.core :as reagent]
            [awebsite.pages.mainpage.mainpage :refer [MainPage]]
            [awebsite.pages.page404 :refer [Page404]]
            [awebsite.pages.loadingpage :refer [LoadingPage]]
            [awebsite.router.router :as router]
            [awebsite.browsereventlisteners :as bels]
            [awebsite.handlers :as handlers]
            [awebsite.db :as mydb]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defn main-panel []
  "The main reagent component"
  (let [current-page (:current-page @mydb/app-state)]
    (cond
      (= :home current-page) [MainPage]
      (= :page404 current-page) [Page404]
      :else [LoadingPage])))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")))


(defn reload []
  (reagent/render [main-panel]
                  (.getElementById js/document "app")))


(defn ^:export main []
  (router/init-routes)
  (dev-setup)
  (handlers/init-states)
  (bels/hook-event-listeners)
  (reload))
