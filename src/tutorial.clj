(ns tutorial)

(defn my-secret-fn [ [x y]  ]
  [ (* x y)])

(defn gen-random-seq-input []
   (repeatedly (fn[] [(rand-int 10) (rand-int 10)] )))

(defn gen-random-seq []
 (let[ random-input (gen-random-seq-input)]
  (map #(hash-map :x % :y (my-secret-fn %)) random-input)))