(ns myrun
      (:require [cortex.experiment.train :as train]
            [cortex.nn.execute :as execute]
            [tutorial :as tut]
            [cortex.nn.layers :as layers]
            [cortex.nn.network :as network]
            :reload
            
              )
      (:gen-class)
      )

(def teach-dataset
  (into [] (take 20000 (tut/gen-random-seq))))

(def test-dataset
  (into [] (take 20000 (tut/gen-random-seq))))

(def my-network
  (network/linear-network
   [(layers/input 2 1 1 :id :x) 
    (layers/linear->tanh 10)
    (layers/tanh)
    (layers/linear 1 :id :y)]))

(defn -main[& args]
  (binding [*out* (clojure.java.io/writer "my-training.log")]
   (train/train-n my-network teach-dataset test-dataset
    :batch-size 1000
    :network-filestem "my-fn"
    :epoch-count 3)))