;; gorilla-repl.fileformat = 1

;; **
;;; # Training for your own function
;; **

;; @@
(ns frightened-resonance
      (:require [cortex.experiment.train :as train]
            [cortex.nn.execute :as execute]
            [tutorial :as tut]
            [cortex.nn.layers :as layers]
            [cortex.nn.network :as network]
            :reload))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(into [] (take 5 (tut/gen-random-seq-input)))
(into [] (take 5 (tut/gen-random-seq)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}],"value":"[3]"}],"value":"[:y [3]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:x</span>","value":":x"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"}],"value":"[1 3]"}],"value":"[:x [1 3]]"}],"value":"{:y [3], :x [1 3]}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"}],"value":"[6]"}],"value":"[:y [6]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:x</span>","value":":x"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"[3 2]"}],"value":"[:x [3 2]]"}],"value":"{:y [6], :x [3 2]}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}],"value":"[0]"}],"value":"[:y [0]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:x</span>","value":":x"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-unkown'>2</span>","value":"2"}],"value":"[0 2]"}],"value":"[:x [0 2]]"}],"value":"{:y [0], :x [0 2]}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"}],"value":"[15]"}],"value":"[:y [15]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:x</span>","value":":x"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"[3 5]"}],"value":"[:x [3 5]]"}],"value":"{:y [15], :x [3 5]}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>30</span>","value":"30"}],"value":"[30]"}],"value":"[:y [30]]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:x</span>","value":":x"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-unkown'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-unkown'>5</span>","value":"5"}],"value":"[6 5]"}],"value":"[:x [6 5]]"}],"value":"{:y [30], :x [6 5]}"}],"value":"[{:y [3], :x [1 3]} {:y [6], :x [3 2]} {:y [0], :x [0 2]} {:y [15], :x [3 5]} {:y [30], :x [6 5]}]"}
;; <=

;; @@
(def teach-dataset
  (into [] (take 20000 (tut/gen-random-seq))))

(def test-dataset
  (into [] (take 20000 (tut/gen-random-seq))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/test-dataset</span>","value":"#'frightened-resonance/test-dataset"}
;; <=

;; @@
(def my-network
  (network/linear-network
   [(layers/input 2 1 1 :id :x) 
    (layers/linear->tanh 10)
    (layers/tanh)
    (layers/linear 1 :id :y)]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/my-network</span>","value":"#'frightened-resonance/my-network"}
;; <=

;; @@
(def trained 
  (binding [*out* (clojure.java.io/writer "my-training.log")]
   (train/train-n my-network teach-dataset test-dataset
    :batch-size 1000
    :network-filestem "my-fn"
    :epoch-count 3)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;frightened-resonance/trained</span>","value":"#'frightened-resonance/trained"}
;; <=

;; @@
(execute/run trained [{:x [5 1.5]}])
;; @@
