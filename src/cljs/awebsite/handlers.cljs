(ns awebsite.handlers
  (:require [awebsite.db :as mydb]
            [awebsite.pages.mainpage.handlers :as mainpagehandler]))


(defn window-resize-handler [width height]
  (.log js/console "window-resize-handler")
  (swap! mydb/app-state assoc-in [:window :height] height)
  (swap! mydb/app-state assoc-in [:window :width] width)
  (swap! mydb/app-state assoc-in [:window :screen-size] (cond
                                                          (< width 768) :xs
                                                          (< width 992) :sm
                                                          (< width 1200) :md
                                                          :else :lg)))

(defn set-window-size []
  (window-resize-handler
    (.-innerWidth js/window)
    (.-innerHeight js/window)))

(defn set-window-focused? [focused?]
  (swap! mydb/app-state assoc-in [:window :focus] focused?))

(defn init-states []
  (set-window-size)
  (mainpagehandler/set-main-page-option)
  (mainpagehandler/set-main-page-content :html :html-home))
