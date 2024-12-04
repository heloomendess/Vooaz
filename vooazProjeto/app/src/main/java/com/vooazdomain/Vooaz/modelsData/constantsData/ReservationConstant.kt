package com.vooazdomain.Vooaz.modelsData.constantsData

import com.vooazdomain.Vooaz.modelsData.datas.Reservation
import java.util.Date

var usersReservation = UsersConts.users
var touristguidesReservation = GuidesContants.guidesObj
var destinationsReservation = Destination.destinations


object  ReservationConstant {
    val Reservations = listOf(
        Reservation(
        userId = users.get(0).userId,
        guideId = touristguides.get(0).tourismGuideId,
        destinationId = destinations.get(0).destinationId,
        planId = users.get(0).userPlans.planId,
            reservationDate = Date(2005)
            )
    )
}
