package com.example.moshe.coderswag.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by moshe on 31/10/2017.
 */

class Category(val title: String, val image: String) : Parcelable {
    override fun toString(): String {
        return this.title
    }


    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(title)
        writeString(image)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Category> = object : Parcelable.Creator<Category> {
            override fun createFromParcel(source: Parcel): Category = Category(source)
            override fun newArray(size: Int): Array<Category?> = arrayOfNulls(size)
        }
    }
}