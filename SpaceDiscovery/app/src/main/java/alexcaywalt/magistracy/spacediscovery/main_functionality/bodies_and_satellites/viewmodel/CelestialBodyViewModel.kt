package alexcaywalt.magistracy.spacediscovery.main_functionality.bodies_and_satellites.viewmodel

import alexcaywalt.magistracy.spacediscovery.main_functionality.basic_models.BasicViewModel
import alexcaywalt.magistracy.spacediscovery.main_functionality.basic_models.ViewModelResult
import alexcaywalt.magistracy.spacediscovery.main_functionality.bodies_and_satellites.api.CelestialBodyApi
import alexcaywalt.magistracy.spacediscovery.main_functionality.bodies_and_satellites.models.CelestialBody
import alexcaywalt.magistracy.spacediscovery.main_functionality.services.CelestialBodyService
import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CelestialBodyViewModel @Inject constructor(var api: CelestialBodyApi): BasicViewModel() {

    val celestialBodies = MutableLiveData<ViewModelResult<List<CelestialBody>>>()

    fun fetchBodiesAndSatellites() {
        celestialBodies.value =
            ViewModelResult(
                arrayListOf(),
                loading = true,
                error = false
            )
        disposable.add(
            //api.getBodiesAndSatellites()
            Single.just(
                arrayListOf(
                    CelestialBody(
                        "Mercury",
                        0,
                        100,
                        "Mercury is the smallest and innermost planet in the Solar System. Its orbital period around the Sun of 87.97 days is the shortest of all the planets in the Solar System. It is named after the Roman deity Mercury, the messenger of the gods.",
                        null,
                        null
                    ),
                    CelestialBody(
                        "Venus",
                        0,
                        100,
                        "Venus is the second planet from the Sun, orbiting it every 224.7 Earth days. With a rotation period of 243 Earth days, Venus takes longer to rotate about its axis than any planet in the Solar System.",
                        null,
                        null
                    ),
                    CelestialBody(
                        "Earth",
                        0,
                        100,
                        "Earth is the third planet from the Sun and the only known astronomical object in the Universe known to harbor life. From Earth, the two brightest celestial bodies are the Sun and the Moon, which during a few million years have almost the same size in the sky, a diameter of about 0.5°, causing the Moon to regularly occult the Sun.",
                        null,
                        null
                    ),
                    CelestialBody(
                        "Mars",
                        0,
                        100,
                        "Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. In English, Mars carries a name of the Roman god of war, and is often referred to as the Red Planet",
                        null,
                        null
                    ),
                    CelestialBody(
                        "Mercury",
                        0,
                        100,
                        "Mercury is the smallest and innermost planet in the Solar System. Its orbital period around the Sun of 87.97 days is the shortest of all the planets in the Solar System. It is named after the Roman deity Mercury, the messenger of the gods.",
                        null,
                        null
                    ),
                    CelestialBody(
                        "The Moon",
                        1,
                        100,
                        "Earth's Moon is an astronomical body that orbits the planet and acts as its only permanent natural satellite. It is the fifth-largest satellite in the Solar System, and the largest among planetary satellites relative to the size of the planet that it orbits (its primary).",
                        null,
                        null
                    ),
                    CelestialBody(
                        "Asteroid 432",
                        2,
                        100,
                        null,
                        null,
                        null
                    ),
                    CelestialBody(
                        "Asteroid 547",
                        null,
                        100,
                        null,
                        null,
                        null
                    )

                )
            )
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<CelestialBody>>() {
                    override fun onSuccess(receivedBodies: List<CelestialBody>) {
                        Log.i("Celestial Body ViewModel", "Celestial bodies have been received successfully")
                        celestialBodies.value =
                            ViewModelResult(
                                CelestialBodyService.prepareBodiesData(receivedBodies),
                                loading = false,
                                error = false
                            )
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Celestial Body ViewModel", "Celestial bodies receiving error", e)
                        celestialBodies.value =
                            ViewModelResult(
                                arrayListOf(),
                                loading = false,
                                error = true
                            )
                    }

                })
        )
    }

}