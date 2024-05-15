package com.example.enquraandroiddeveloperchallenge.data.model

import com.google.gson.annotations.SerializedName

data class BankData(
    @SerializedName("ID") val id: Int,
    @SerializedName("dc_SEHIR") val city: String,
    @SerializedName("dc_ILCE") val district: String,
    @SerializedName("dc_BANKA_SUBE") val bankBranch: String,
    @SerializedName("dc_BANKA_TIPI") val bankType: String,
    @SerializedName("dc_BANK_KODU") val bankCode: String,
    @SerializedName("dc_ADRES_ADI") val addressName: String,
    @SerializedName("dc_ADRES") val address: String,
    @SerializedName("dc_POSTA_KODU") val postalCode: String,
    @SerializedName("dc_ON_OFF_LINE") val onOffLine: String,
    @SerializedName("dc_ON_OFF_SITE") val onOffSite: String,
    @SerializedName("dc_BOLGE_KOORDINATORLUGU") val regionCoordinator: String,
    @SerializedName("dc_EN_YAKIM_ATM") val nearestAtm: String
)