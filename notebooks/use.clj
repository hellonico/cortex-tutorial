;; gorilla-repl.fileformat = 1

;; **
;;; # Using your own network
;;; 
;; **

;; @@
(ns sunset-cliff
    (:require [cortex.nn.execute :as execute]
              [cortex.util :as util]))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def nippy (util/read-nippy-file "mynetwork.nippy"))
(execute/run nippy [{:x [1 3]}{:x [1 4]}])
;; @@
;; ->
;;; CUDA backend creation failed, reverting to CPU
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>3.0284347534179688</span>","value":"3.0284347534179688"}],"value":"[3.0284347534179688]"}],"value":"[:y [3.0284347534179688]]"}],"value":"{:y [3.0284347534179688]}"},{"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:y</span>","value":":y"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>4.063351631164551</span>","value":"4.063351631164551"}],"value":"[4.063351631164551]"}],"value":"[:y [4.063351631164551]]"}],"value":"{:y [4.063351631164551]}"}],"value":"[{:y [3.0284347534179688]} {:y [4.063351631164551]}]"}
;; <=

;; @@

;; @@
