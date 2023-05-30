package com.br.wcabral.kotlin.android.githubcompose.data

import org.junit.Assert.*
import com.br.wcabral.kotlin.android.githubcompose.data.GithubApi
import com.br.wcabral.kotlin.android.githubcompose.data.GithubRepository
import com.br.wcabral.kotlin.android.githubcompose.data.model.Repo
import com.br.wcabral.kotlin.android.githubcompose.data.model.User
import com.br.wcabral.kotlin.android.githubcompose.data.model.UserDetail
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
class GithubRepositoryImplTest {

    private val githubApi = mockk<GithubApi>()
    private val githubRepository: GithubRepository = GithubRepositoryImpl(githubApi)

    @Test
    fun `When getUsers called then should call getUsers from the API`() = runTest {
        // Given
        val users = listOf(User())
        coEvery { githubApi.getUsers() } returns users

        // When
        val result = githubRepository.getUsers()

        // Then
        assert(result.isSuccess)
        coVerify(exactly = 1) { githubApi.getUsers() }
        confirmVerified(githubApi)
    }

    @Test
    fun `When getUser called then should call getUser from the API`() = runTest {
        // Given
        val userId = "lnlan1810"
        coEvery { githubApi.getUser(any()) } returns UserDetail()

        // When
        val result = githubRepository.getUser(userId)

        // Then
        assert(result.isSuccess)
        coVerify(exactly = 1) { githubApi.getUser(userId) }
        confirmVerified(githubApi)
    }

    @Test
    fun `When getRepos called then should call getRepos from the API`() = runTest {
        // Given
        val userId = "lnlan1810"
        coEvery { githubApi.getRepos(userId) } returns listOf(Repo())

        // When
        val result = githubRepository.getRepos(userId)

        // Then
        assert(result.isSuccess)
        coVerify(exactly = 1) { githubApi.getRepos(userId) }
        confirmVerified(githubApi)
    }

    @Test
    fun `Given an exception When getUsers called then returns failure`() = runTest {
        // Given
        coEvery { githubApi.getUsers() } throws Exception("")

        // When
        val result = githubRepository.getUsers()

        // Then
        assert(result.isFailure)
    }

    @Test
    fun `Given an exception When getUser called then returns failure`() = runTest {
        // Given
        coEvery { githubApi.getUser(any()) } throws Exception("")

        // When
        val result = githubRepository.getUser("lnlan1810")

        // Then
        assert(result.isFailure)
    }

    @Test
    fun `Given an exception When getRepos called then returns failure`() = runTest {
        // Given
        coEvery { githubApi.getRepos(any()) } throws Exception("")

        // When
        val result = githubRepository.getRepos("lnlan1810")

        // Then
        assert(result.isFailure)
    }
}