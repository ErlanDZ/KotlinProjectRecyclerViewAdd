package com.example.kotlinprojectrecyclerviewadd

import com.example.kotlinprojectrecyclerviewadd.data.MainModal

class TextRepository {
   // private val catModelList: MutableList<MainModal> = ArrayList()
     private var catModelList =  mutableListOf<MainModal>()


    fun getListOfCatHTTP(): MutableList<MainModal> {
        catModelList.add(MainModal( "Continue"))
        catModelList.add(MainModal( "Switching Protocols"))
        catModelList.add(MainModal( "Processing"))
        catModelList.add(MainModal( "Early Hints"))
        catModelList.add(MainModal( "OK"))
        catModelList.add(MainModal( "Created"))
        catModelList.add(MainModal( "Accepted"))
        catModelList.add(MainModal( "Non-Authoritative Information"))
        catModelList.add(MainModal( "No Content"))
        catModelList.add(MainModal( "Partial Content"))
        catModelList.add(MainModal( "Multi-Status"))
        catModelList.add(MainModal( "Multiple Choices"))
        catModelList.add(MainModal( "Moved Permanently"))
        catModelList.add(MainModal( "Found"))
        catModelList.add(MainModal( "See Other"))
        catModelList.add(MainModal( "Not Modified"))
        catModelList.add(MainModal( "Use Proxy"))
        catModelList.add(MainModal( "Temporary Redirect"))
        catModelList.add(MainModal( "Permanent Redirect"))
        catModelList.add(MainModal( "Bad Request"))
        catModelList.add(MainModal( "Unauthorized"))
        catModelList.add(MainModal( "Payment Required"))
        catModelList.add(MainModal( "Forbidden"))

        return catModelList
    }
}