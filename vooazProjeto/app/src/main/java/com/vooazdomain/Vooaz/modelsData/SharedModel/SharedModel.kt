package com.vooazdomain.Vooaz.modelsData.SharedModel

import androidx.lifecycle.ViewModel
import com.vooazdomain.Vooaz.modelsData.datas.TourismGuide
import com.vooazdomain.Vooaz.modelsData.datas.User

class SharedModel : ViewModel() {
    var selectedUser: User? = null
        private set
    var selectedOtherUsers: User? = null
        private set
    var selectedGuides: TourismGuide? = null
        private set

    fun setSelectedUser(user: User) {
        selectedUser = user
    }

    fun setSelectedOtherUser(user: User) {
        selectedOtherUsers = user
    }

    fun setSelectedGuide(guide: TourismGuide) {
        selectedGuides = guide
    }
}