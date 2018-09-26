package com.example.dsymhove.starterproject


class Profile {

    companion object Factory {
        fun create(): Profile = Profile()
    }

    var name: String? = null
    var email: String? = null
    var phone: String? = null
    var drawable: Int? = null

    constructor(name: String, email: String, phone: String, drawable: Int) {
        this.name = name
        this.email = email
        this.phone = phone
        this.drawable = drawable
    }
}