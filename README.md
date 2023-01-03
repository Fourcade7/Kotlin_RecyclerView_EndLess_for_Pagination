# Kotlin_RecyclerView_EndLess_for_Pagination

    var pastVisibleItem=0
    var visibleItemCount=0
    var totalItemCount=0






         val layoutManager=LinearLayoutManager(this@MainActivity)
                recyclerView.layoutManager=layoutManager
                recyclerView.adapter=catAdapter
                recyclerView.addOnScrollListener(object : OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                     super.onScrolled(recyclerView, dx, dy)
                
                visibleItemCount=layoutManager.childCount
                totalItemCount=layoutManager.itemCount
                pastVisibleItem=layoutManager.findLastCompletelyVisibleItemPosition()
                     if (dy>0){
                
                    //Toast.makeText(this@MainActivity,"dy:$dy\n$visibleItemCount",Toast.LENGTH_SHORT).show()
                   
                   title="$visibleItemCount\n$totalItemCount\n$pastVisibleItem"
                    
                    if (pastVisibleItem==totalItemCount-1){
                        title="Eng Game"
                    }

                }

            }
        })
