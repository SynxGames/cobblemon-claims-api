package games.synx.cobblemon.claims.api

import org.jetbrains.annotations.ApiStatus.Internal
import java.util.Optional

object ClaimsApiAccessor {

    lateinit var claimsApi: ClaimsApi

    /**
     * Get the Claims API Instance
     *
     * @return Optional<ClaimsApi>
     */
    fun getApi(): Optional<ClaimsApi> {
        if(this::claimsApi::isInitialized.get()) {
            return Optional.of(claimsApi)
        } else {
            return Optional.empty()
        }
    }

    /**
     * **INTERNAL USE ONLY**
     */
    @Internal
    fun setApi(claimsApi: ClaimsApi) {
        this.claimsApi = claimsApi
    }

}