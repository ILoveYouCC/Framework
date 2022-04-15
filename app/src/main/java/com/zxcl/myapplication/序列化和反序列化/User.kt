package com.zxcl.myapplication.序列化和反序列化

data class User(
    /**
     * @Transient 修饰的，序列化对象的过程中，此属性不会被序列化
     */
    @Transient
    var age: Int,
    var name: String
): Serializable
