package com.vooazdomain.Vooaz.modelsData.constantsData

import com.vooazdomain.Vooaz.modelsData.datas.Assessment
import com.vooazdomain.Vooaz.modelsData.datas.TourismGuide
import java.util.Date

var users = UsersConts.users
var touristguides = GuidesContants.guidesObj
var destinations = Destination.destinations

object assessmentConstants {
    val assessment = listOf(
        Assessment(
            userId = users.get(0).userId,
            guideId = touristguides.get(0).tourismGuideId,
            destinationId = destinations.get(0).destinationId,
            rating = 10,
            comments = "Good choice",
            date = Date(2003)
        )
    )
}
