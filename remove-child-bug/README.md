# What's wrong?

* Run `boot dev`
* Open `localhost:8000`
* Input anything into the text box
* Select one of the results
* Save `index.cljs.hl` to trigger `boot-reload`
* Notice the exception: `Uncaught NotFoundError: Failed to execute 'removeChild' on 'Node': The node to be removed is not a child of this node.`

The exception happens because `hoplon.core/merge-kids` receives duplicate
autocomplete `ul` element to remove.
