;; gorilla-repl.fileformat = 1

;; **
;;; # Training for your own function
;; **

;; @@
(ns frightened-resonance
      (:require [cortex.experiment.train :as train]
            [cortex.nn.execute :as execute]
            [cortex.nn.layers :as layers]
            [cortex.nn.network :as network]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn my-secret-fn [ [x y]  ]
  [ (* x y)])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/my-secret-fn</span>","value":"#'frightened-resonance/my-secret-fn"}
;; <=

;; @@
(defn gen-random-set []
  (let[ random-input (repeatedly (fn[] [(rand-int 10) (rand-int 10)] ))]
  (map #(hash-map :x % :y (my-secret-fn %)) random-input)))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/gen-random-set</span>","value":"#'frightened-resonance/gen-random-set"}
;; <=

;; @@
(def my-dataset
  (into [] (take 20000 (gen-random-set))))

(def test-dataset
  (into [] (take 20000 (gen-random-set))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/test-dataset</span>","value":"#'frightened-resonance/test-dataset"}
;; <=

;; @@
(def nn1
  (network/linear-network
   [(layers/input 2 1 1 :id :x) 
      (layers/linear->tanh 10)
      (layers/tanh)
      (layers/linear 1 :id :y)]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/nn1</span>","value":"#'frightened-resonance/nn1"}
;; <=

;; @@
(def trained 
  (binding [*out* (clojure.java.io/writer "my-training.log")]
   (train/train-n nn1 my-dataset test-dataset
    :batch-size 1000
    :network-filestem "my-fn"
    :epoch-count 3000
    :simple-loss-print? false)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/trained</span>","value":"#'frightened-resonance/trained"}
;; <=

;; @@
(def new-dataset
  (into [] (first (gen-random-set))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/new-dataset</span>","value":"#'frightened-resonance/new-dataset"}
;; <=

;; @@
(execute/run trained new-dataset)
;; @@

;; @@

;; @@
