package com.legado.ventagps.model

data class CustomerListResponse(
    var status:StatusResponse,
    var customers: ArrayList<Customer>? = null

)

data class ProductListResponse(
    var status:StatusResponse,
    var products: ArrayList<Product>? = null

)
data class UserResponse(
    var status:StatusResponse,
    var user: User? = null

)

data class Product(
    var code:String,
    var description:String,
    var uri:String,
    var price:Double,
    var isBonif:Boolean

)

data class User(
    var userEmail:String,
    var fullName:String,
    var password:String,
    var username:String,
    var email:String,
    var dni:String,
    var celular:String
)
data class Customer(
    var code:String,
    var description:String,
    var address:String,
    var status:String
)
data class StatusResponse(
    var statusCode: String = "",
    var statusText: String = ""
  )

data class LoginResponse(
    val user_id: String? = null,
    val token: String,
    val user_display_name: String,
    val user_email: String,
    val user_nicename: String,
    val message: String,
    val user_role: List<String>? = null,
    val avatar: String,
    val profile_image: String
)