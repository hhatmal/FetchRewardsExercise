package com.example.fetchrewardsexercise.presentation.overview

import com.example.fetchrewardsexercise.data.repository.FakeUserRepository
import com.example.fetchrewardsexercise.domain.User
import com.example.fetchrewardsexercise.domain.UserDataValidator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

// this implementation for checking valid user shouldn't be tested here
// for sake of time, I put it here but it should be tested in it's own class
class OverviewViewModelTest {
    @JvmField
    @Rule
    var mRule: MockitoRule = MockitoJUnit.rule()

    val dispatcher = TestCoroutineDispatcher()

    private lateinit var repository: FakeUserRepository
    private lateinit var userDataValidator: UserDataValidator
    private lateinit var viewModel: OverviewViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)

        repository = FakeUserRepository()
        userDataValidator = UserDataValidator() // should be abstracted to avoid hard implementation when testing
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testUserUiStateNotEmptyWhenGetUsersReceivesValidUser() {
        repository.users.add(
            User(
                id = "1",
                listId = "1",
                name = "tim"
            )
        )

        viewModel = OverviewViewModel(
            userRepository = repository,
            userDataValidator = userDataValidator
        )

        assertTrue(viewModel.state.userUis.size > 0)
    }

    @Test
    fun testUserUiStateEmptyWhenGetUsersReceivesNoValidUser() {
        repository.users.add(
            User(
                id = "1",
                listId = "1",
                name = ""
            )
        )

        viewModel = OverviewViewModel(
            userRepository = repository,
            userDataValidator = userDataValidator
        )

        assertTrue(viewModel.state.userUis.size == 0)
    }
}