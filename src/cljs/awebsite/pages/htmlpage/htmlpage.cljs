(ns awebsite.pages.htmlpage.htmlpage
  (:require [awebsite.db :as mydb]
            [awebsite.pages.mainpage.subs :as mainpagesubs]
            [awebsite.pages.mainpage.handlers :as mainpagehandlers]
            [clojure.string :as str]
            [reagent.core :as reagent]))

(defn HtmlHome
  []
  [:div
   [:h1 "HTML5 Tutorial"]
   [:hr]
   [:div
    [:p "With HTML you can create your own Website."]
    [:p "This tutorial teaches you everything about HTML."]
    [:p "HTML is easy to learn - You will enjoy it."]]
   [:hr]
   [:h2 "Examples in every Chapter"]
   [:p "This HTML tutorial contains hundreds of HTML examples."]
   [:p "With our online HTML editor, you can edit the HTML, and click on a button to view the result."]
   [:h2 "HTML Examples"]
   [:p "At the end of the HTML tutorial, you can find more than 200 examples."]
   [:p "With our online editor, you can edit and test each example yourself."]])

(defn HtmlIntroduction
  []
  [:div
   [:h1 "HTML Introduction"]
   [:hr]
   [:h2 "What is HTML?"]
   [:p "HTML is the standard markup language for creating Webpages."]
   [:ul
    [:li "HTML stands for Hyper Text Markup Language"]
    [:li "HTML describes the structure of Webpages using markup"]
    [:li "HTML elements are the building blocks of HTML pages"]
    [:li "HTML elements are represented by tags"]
    [:li "HTML tags label pieces of content such as \"heading\", \"paragraph\", \"table\", and so on"]
    [:li "Browsers do not display the HTML tags, but use them to render the content page"]]
   [:hr]
   [:h2 "A Simple HTML Document"]
   [:h3 "Example explained"]
   [:hr]
   [:h2 "HTML Tags"]
   [:p "HTML tags are element names surrounded by angle brackets:"]])

(defn HtmlEditors
  []
  [:div
   [:h1 "HTML Editors"]
   [:hr]
   [:h2 "Write HTML Using Notepad or TextEditor"]
   [:p "Webpages can be created and modified by using professional HTML editors"]
   [:p "However, for learning HTML we recommend a simple text editor like Notepad (PC) or TextEdit (Mac)."]
   [:p "We believe using a simple text editor is a good way to learn HTML."]
   [:p "Follow the four steps below to create your first web page with Notepad or TextEdit."]
   [:hr]
   [:h2 "Step 1: Open Notepad (PC)"]
   [:p
    [:strong "Windows 8 or later: "]]
   [:p "Open the "
    [:strong "Start Screen"]
    " (the window symbol at the bottom left on your screen). Type "
    [:strong "Notepad"]
    "."]
   [:p
    [:strong "Window 7 or earlier: "]]
   [:p
    "Open "
    [:strong "Start >"]
    [:strong "Programs >"]
    [:strong "Accessories >"]
    [:strong "Notepad"]]
   [:hr]
   [:h2 "Step 1: Open TextEdit (Mac)"]
   [:p "Open "
    [:strong "Finder > Application > TextEdit"]]
   [:p "Also change some preferences to get the application to save files correctly. In "
    [:strong "Preferences > Format > "]
    "choose "
    [:strong "Plain Text"]]
   [:p "Then under \"Open and Save\", check the box that says \"Ignore rich text commands in HTML files\"."]
   [:p [:strong "Then open a new document to place the code."]]
   [:hr]
   [:h2 "Step 2: Write Some HTML"]
   [:p "Write or copy some HTML into Notepad."]])

(defn HtmlPage
  []
  (let [subcontent (mainpagesubs/get-main-page-subcontent)]
    (cond
        (= :html-home subcontent) [HtmlHome]
        (= :html-introduction subcontent) [HtmlIntroduction]
        (= :html-editors subcontent) [HtmlEditors])))
