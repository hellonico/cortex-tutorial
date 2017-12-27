;; gorilla-repl.fileformat = 1

;; **
;;; # Using your own network
;;; 
;; **

;; @@
(ns sunset-cliff
    (:require [cortex.nn.execute :as execute]
              [cortex.util :as util]
              [tutorial :as tut]
              [gorilla-plot.core :as plot]
              :reload))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ### reloading and running the network
;; **

;; @@
(def input (into [] (take 30 (tut/gen-random-seq))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sunset-cliff/input</span>","value":"#'sunset-cliff/input"}
;; <=

;; @@
(def trained (util/read-nippy-file "mynetwork.nippy"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sunset-cliff/trained</span>","value":"#'sunset-cliff/trained"}
;; <=

;; @@
(keys trained)
(select-keys trained [:epoch-count :cv-loss])
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:epoch-count</span>","value":":epoch-count"},{"type":"html","content":"<span class='clj-long'>3000</span>","value":"3000"}],"value":"[:epoch-count 3000]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:cv-loss</span>","value":":cv-loss"},{"type":"html","content":"<span class='clj-double'>0.030818421955475947</span>","value":"0.030818421955475947"}],"value":"[:cv-loss 0.030818421955475947]"}],"value":"{:epoch-count 3000, :cv-loss 0.030818421955475947}"}
;; <=

;; @@
(execute/run trained [{:x [5 1.5]}])
;; @@
;; ->
;;; CUDA backend creation failed, reverting to CPU
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>7.420461177825928</span>","value":"7.420461177825928"}],"value":"[7.420461177825928]"}],"value":"[:y [7.420461177825928]]"}],"value":"{:y [7.420461177825928]}"}],"value":"[{:y [7.420461177825928]}]"}
;; <=

;; @@
(def results (execute/run trained input))
;; @@
;; ->
;;; CUDA backend creation failed, reverting to CPU
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sunset-cliff/results</span>","value":"#'sunset-cliff/results"}
;; <=

;; @@
(clojure.pprint/pprint (take 3 results))
;; @@
;; ->
;;; ({:y [15.263650894165039]}
;;;  {:y [6.846651077270508]}
;;;  {:y [10.06048583984375]})
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; **
;;; ### plotting
;; **

;; @@
(plot/list-plot (flatten (map :y results)) :color "#ffcc77" :joined true)
;; @@
;; =>
;;; {"type":"vega","content":{"width":400,"height":247.2187957763672,"padding":{"top":10,"left":55,"bottom":40,"right":10},"data":[{"name":"31f2f5ac-01a2-45df-8832-a5679ece7f5d","values":[{"x":0,"y":10.10285758972168},{"x":1,"y":15.263650894165039},{"x":2,"y":26.98769187927246},{"x":3,"y":54.22013854980469},{"x":4,"y":5.78465461730957},{"x":5,"y":18.108488082885742},{"x":6,"y":24.060853958129883},{"x":7,"y":28.057178497314453},{"x":8,"y":48.25645065307617},{"x":9,"y":24.13358497619629},{"x":10,"y":12.056215286254883},{"x":11,"y":32.01298522949219},{"x":12,"y":0.3547849655151367},{"x":13,"y":12.030367851257324},{"x":14,"y":8.75982666015625},{"x":15,"y":35.85480499267578},{"x":16,"y":-0.03414440155029297},{"x":17,"y":63.29235076904297},{"x":18,"y":3.0284347534179688},{"x":19,"y":0.05006980895996094},{"x":20,"y":7.971913814544678},{"x":21,"y":5.945075511932373},{"x":22,"y":63.1173210144043},{"x":23,"y":7.937830448150635},{"x":24,"y":34.96635055541992},{"x":25,"y":44.93412399291992},{"x":26,"y":42.054134368896484},{"x":27,"y":3.911296844482422},{"x":28,"y":-0.25989723205566406},{"x":29,"y":24.060853958129883}]}],"marks":[{"type":"line","from":{"data":"31f2f5ac-01a2-45df-8832-a5679ece7f5d"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"y":{"scale":"y","field":"data.y"},"stroke":{"value":"#ffcc77"},"strokeWidth":{"value":2},"strokeOpacity":{"value":1}}}}],"scales":[{"name":"x","type":"linear","range":"width","zero":false,"domain":{"data":"31f2f5ac-01a2-45df-8832-a5679ece7f5d","field":"data.x"}},{"name":"y","type":"linear","range":"height","nice":true,"zero":false,"domain":{"data":"31f2f5ac-01a2-45df-8832-a5679ece7f5d","field":"data.y"}}],"axes":[{"type":"x","scale":"x"},{"type":"y","scale":"y"}]},"value":"#gorilla_repl.vega.VegaView{:content {:width 400, :height 247.2188, :padding {:top 10, :left 55, :bottom 40, :right 10}, :data [{:name \"31f2f5ac-01a2-45df-8832-a5679ece7f5d\", :values ({:x 0, :y 10.10285758972168} {:x 1, :y 15.263650894165039} {:x 2, :y 26.98769187927246} {:x 3, :y 54.22013854980469} {:x 4, :y 5.78465461730957} {:x 5, :y 18.108488082885742} {:x 6, :y 24.060853958129883} {:x 7, :y 28.057178497314453} {:x 8, :y 48.25645065307617} {:x 9, :y 24.13358497619629} {:x 10, :y 12.056215286254883} {:x 11, :y 32.01298522949219} {:x 12, :y 0.3547849655151367} {:x 13, :y 12.030367851257324} {:x 14, :y 8.75982666015625} {:x 15, :y 35.85480499267578} {:x 16, :y -0.03414440155029297} {:x 17, :y 63.29235076904297} {:x 18, :y 3.0284347534179688} {:x 19, :y 0.05006980895996094} {:x 20, :y 7.971913814544678} {:x 21, :y 5.945075511932373} {:x 22, :y 63.1173210144043} {:x 23, :y 7.937830448150635} {:x 24, :y 34.96635055541992} {:x 25, :y 44.93412399291992} {:x 26, :y 42.054134368896484} {:x 27, :y 3.911296844482422} {:x 28, :y -0.25989723205566406} {:x 29, :y 24.060853958129883})}], :marks [{:type \"line\", :from {:data \"31f2f5ac-01a2-45df-8832-a5679ece7f5d\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :stroke {:value \"#ffcc77\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 1}}}}], :scales [{:name \"x\", :type \"linear\", :range \"width\", :zero false, :domain {:data \"31f2f5ac-01a2-45df-8832-a5679ece7f5d\", :field \"data.x\"}} {:name \"y\", :type \"linear\", :range \"height\", :nice true, :zero false, :domain {:data \"31f2f5ac-01a2-45df-8832-a5679ece7f5d\", :field \"data.y\"}}], :axes [{:type \"x\", :scale \"x\"} {:type \"y\", :scale \"y\"}]}}"}
;; <=

;; @@
(plot/compose
 (plot/list-plot (flatten (map :y results)) :color "blue" :opacity 0.3 :joined true)
 (plot/list-plot (flatten (map #(let [v (% :x)] (* (first v) (second v))) input)) :color "red" :opacity 0.1 :joined true))
;; @@
;; =>
;;; {"type":"vega","content":{"width":400,"height":247.2187957763672,"padding":{"top":10,"left":55,"bottom":40,"right":10},"scales":[{"name":"x","type":"linear","range":"width","zero":false,"domain":{"data":"0c4dd9d2-8b06-41a6-82f4-4dc1fdfdfb89","field":"data.x"}},{"name":"y","type":"linear","range":"height","nice":true,"zero":false,"domain":{"data":"0c4dd9d2-8b06-41a6-82f4-4dc1fdfdfb89","field":"data.y"}}],"axes":[{"type":"x","scale":"x"},{"type":"y","scale":"y"}],"data":[{"name":"0c4dd9d2-8b06-41a6-82f4-4dc1fdfdfb89","values":[{"x":0,"y":10.10285758972168},{"x":1,"y":15.263650894165039},{"x":2,"y":26.98769187927246},{"x":3,"y":54.22013854980469},{"x":4,"y":5.78465461730957},{"x":5,"y":18.108488082885742},{"x":6,"y":24.060853958129883},{"x":7,"y":28.057178497314453},{"x":8,"y":48.25645065307617},{"x":9,"y":24.13358497619629},{"x":10,"y":12.056215286254883},{"x":11,"y":32.01298522949219},{"x":12,"y":0.3547849655151367},{"x":13,"y":12.030367851257324},{"x":14,"y":8.75982666015625},{"x":15,"y":35.85480499267578},{"x":16,"y":-0.03414440155029297},{"x":17,"y":63.29235076904297},{"x":18,"y":3.0284347534179688},{"x":19,"y":0.05006980895996094},{"x":20,"y":7.971913814544678},{"x":21,"y":5.945075511932373},{"x":22,"y":63.1173210144043},{"x":23,"y":7.937830448150635},{"x":24,"y":34.96635055541992},{"x":25,"y":44.93412399291992},{"x":26,"y":42.054134368896484},{"x":27,"y":3.911296844482422},{"x":28,"y":-0.25989723205566406},{"x":29,"y":24.060853958129883}]},{"name":"d94ccb66-df7b-4d9d-94fc-6156a5ec6513","values":[{"x":0,"y":10},{"x":1,"y":15},{"x":2,"y":27},{"x":3,"y":54},{"x":4,"y":6},{"x":5,"y":18},{"x":6,"y":24},{"x":7,"y":28},{"x":8,"y":48},{"x":9,"y":24},{"x":10,"y":12},{"x":11,"y":32},{"x":12,"y":0},{"x":13,"y":12},{"x":14,"y":9},{"x":15,"y":36},{"x":16,"y":0},{"x":17,"y":64},{"x":18,"y":3},{"x":19,"y":0},{"x":20,"y":8},{"x":21,"y":6},{"x":22,"y":63},{"x":23,"y":8},{"x":24,"y":35},{"x":25,"y":45},{"x":26,"y":42},{"x":27,"y":4},{"x":28,"y":0},{"x":29,"y":24}]}],"marks":[{"type":"line","from":{"data":"0c4dd9d2-8b06-41a6-82f4-4dc1fdfdfb89"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"y":{"scale":"y","field":"data.y"},"stroke":{"value":"blue"},"strokeWidth":{"value":2},"strokeOpacity":{"value":0.3}}}},{"type":"line","from":{"data":"d94ccb66-df7b-4d9d-94fc-6156a5ec6513"},"properties":{"enter":{"x":{"scale":"x","field":"data.x"},"y":{"scale":"y","field":"data.y"},"stroke":{"value":"red"},"strokeWidth":{"value":2},"strokeOpacity":{"value":0.1}}}}]},"value":"#gorilla_repl.vega.VegaView{:content {:width 400, :height 247.2188, :padding {:top 10, :left 55, :bottom 40, :right 10}, :scales [{:name \"x\", :type \"linear\", :range \"width\", :zero false, :domain {:data \"0c4dd9d2-8b06-41a6-82f4-4dc1fdfdfb89\", :field \"data.x\"}} {:name \"y\", :type \"linear\", :range \"height\", :nice true, :zero false, :domain {:data \"0c4dd9d2-8b06-41a6-82f4-4dc1fdfdfb89\", :field \"data.y\"}}], :axes [{:type \"x\", :scale \"x\"} {:type \"y\", :scale \"y\"}], :data ({:name \"0c4dd9d2-8b06-41a6-82f4-4dc1fdfdfb89\", :values ({:x 0, :y 10.10285758972168} {:x 1, :y 15.263650894165039} {:x 2, :y 26.98769187927246} {:x 3, :y 54.22013854980469} {:x 4, :y 5.78465461730957} {:x 5, :y 18.108488082885742} {:x 6, :y 24.060853958129883} {:x 7, :y 28.057178497314453} {:x 8, :y 48.25645065307617} {:x 9, :y 24.13358497619629} {:x 10, :y 12.056215286254883} {:x 11, :y 32.01298522949219} {:x 12, :y 0.3547849655151367} {:x 13, :y 12.030367851257324} {:x 14, :y 8.75982666015625} {:x 15, :y 35.85480499267578} {:x 16, :y -0.03414440155029297} {:x 17, :y 63.29235076904297} {:x 18, :y 3.0284347534179688} {:x 19, :y 0.05006980895996094} {:x 20, :y 7.971913814544678} {:x 21, :y 5.945075511932373} {:x 22, :y 63.1173210144043} {:x 23, :y 7.937830448150635} {:x 24, :y 34.96635055541992} {:x 25, :y 44.93412399291992} {:x 26, :y 42.054134368896484} {:x 27, :y 3.911296844482422} {:x 28, :y -0.25989723205566406} {:x 29, :y 24.060853958129883})} {:name \"d94ccb66-df7b-4d9d-94fc-6156a5ec6513\", :values ({:x 0, :y 10} {:x 1, :y 15} {:x 2, :y 27} {:x 3, :y 54} {:x 4, :y 6} {:x 5, :y 18} {:x 6, :y 24} {:x 7, :y 28} {:x 8, :y 48} {:x 9, :y 24} {:x 10, :y 12} {:x 11, :y 32} {:x 12, :y 0} {:x 13, :y 12} {:x 14, :y 9} {:x 15, :y 36} {:x 16, :y 0} {:x 17, :y 64} {:x 18, :y 3} {:x 19, :y 0} {:x 20, :y 8} {:x 21, :y 6} {:x 22, :y 63} {:x 23, :y 8} {:x 24, :y 35} {:x 25, :y 45} {:x 26, :y 42} {:x 27, :y 4} {:x 28, :y 0} {:x 29, :y 24})}), :marks ({:type \"line\", :from {:data \"0c4dd9d2-8b06-41a6-82f4-4dc1fdfdfb89\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :stroke {:value \"blue\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 0.3}}}} {:type \"line\", :from {:data \"d94ccb66-df7b-4d9d-94fc-6156a5ec6513\"}, :properties {:enter {:x {:scale \"x\", :field \"data.x\"}, :y {:scale \"y\", :field \"data.y\"}, :stroke {:value \"red\"}, :strokeWidth {:value 2}, :strokeOpacity {:value 0.1}}}})}}"}
;; <=

;; **
;;; ### retraining
;; **

;; @@
(require '[cortex.experiment.train :as train])

(def teach-dataset
  (into [] (take 200 (tut/gen-random-seq))))

(def test-dataset
  (into [] (take 200 (tut/gen-random-seq))))

(def re-trained 
  (binding [*out* (clojure.java.io/writer "re-train.log")]
   (train/train-n trained teach-dataset test-dataset
    :batch-size 100
    :network-filestem "retrained"
    :epoch-count 50)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;sunset-cliff/re-trained</span>","value":"#'sunset-cliff/re-trained"}
;; <=

;; @@

;; @@
