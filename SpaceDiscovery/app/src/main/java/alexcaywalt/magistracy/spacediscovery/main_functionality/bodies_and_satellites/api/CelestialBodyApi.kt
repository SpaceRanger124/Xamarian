package alexcaywalt.magistracy.spacediscovery.main_functionality.bodies_and_satellites.api

import alexcaywalt.magistracy.spacediscovery.main_functionality.bodies_and_satellites.models.CelestialBody
import io.reactivex.Single
import retrofit2.http.GET

interface CelestialBodyApi {

    @GET("bodies_and_satellites")
    fun getBodiesAndSatellites(): Single<List<CelestialBody>>

}