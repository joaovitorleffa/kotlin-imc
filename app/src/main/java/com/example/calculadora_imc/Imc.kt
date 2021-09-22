package com.example.calculadora_imc

import android.os.Parcel
import android.os.Parcelable

class Imc(var name: String?, var genre: String?, var height: Double, var weight: Double): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    fun calculateImc(): Double {
        return this.weight / (this.height * this.height)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(genre)
        parcel.writeDouble(height)
        parcel.writeDouble(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Imc> {
        override fun createFromParcel(parcel: Parcel): Imc {
            return Imc(parcel)
        }

        override fun newArray(size: Int): Array<Imc?> {
            return arrayOfNulls(size)
        }
    }

}