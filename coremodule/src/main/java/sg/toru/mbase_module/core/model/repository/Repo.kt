package sg.toru.mbase_module.core.model.repository

import sg.toru.mbase_module.core.network.Network
import sg.toru.mbase_module.core.network.NetworkService

object Repo {
    private val networkService:NetworkService = Network.retrofit.create(NetworkService::class.java)

    suspend fun requestAllPosts() = networkService.getAllPosts()
    suspend fun requestPostById(id:String) = networkService.getPostById(id)
}