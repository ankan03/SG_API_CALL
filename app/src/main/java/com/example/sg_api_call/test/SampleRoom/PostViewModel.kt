//package com.example.sg_api_call.test.SampleRoom
//
//import android.app.Application
//import androidx.lifecycle.*
//import kotlinx.coroutines.*
//
////class PostViewModel(
////    private val postKey: Long = 0L,
////    val postDatabase: PostDao) : ViewModel() {
////
////    private val postTracker = MutableLiveData<Boolean?>()
////    val postLiveDataTracker: LiveData<Boolean?>
////        get() = postTracker
////
////    fun doneNavigating() {
////        postTracker.value = null
////    }
////    fun onSetSleepQuality(quality: Int) {
////        viewModelScope.launch {
////            val tonight = postDatabase.get(postKey) ?: return@launch
////            postDatabase.update(tonight)
////            postTracker.value = true
////        }
////    }
////}
//
//class PostViewModel(
//    val postDatabase: PostDao,
//    application: Application
//) : AndroidViewModel(application) {
//
//
//    private var tonight = MutableLiveData<PostTable?>()
//
//    private val postList = postDatabase.getAllPosts()
//
//    /**
//     * Converted nights to Spanned for displaying.
//     */
//    val postsString = Transformations.map(postList) { posts ->
//        formatNights(posts, application.resources)
//    }
//
//    /**
//     * Variable that tells the Fragment to navigate to a specific [SleepQualityFragment]
//     *
//     * This is private because we don't want to expose setting this value to the Fragment.
//     */
//
//    private val _navigateToSleepQuality = MutableLiveData<PostTable>()
//    /**
//     * Call this immediately after calling `show()` on a toast.
//     *
//     * It will clear the toast request, so if the user rotates their phone it won't show a duplicate
//     * toast.
//     */
//
//    /**
//     * If this is non-null, immediately navigate to [SleepQualityFragment] and call [doneNavigating]
//     */
//    val navigateToSleepQuality: LiveData<PostTable>
//        get() = _navigateToSleepQuality
//
//    /**
//     * Call this immediately after navigating to [SleepQualityFragment]
//     *
//     * It will clear the navigation request, so if the user rotates their phone it won't navigate
//     * twice.
//     */
//    fun doneNavigating() {
//        _navigateToSleepQuality.value = null
//    }
//
//    init {
//        initializeTonight()
//    }
//
//    private fun initializeTonight() {
//        viewModelScope.launch {
//            tonight.value = getRecentPostFromDatabase()
//        }
//    }
//
//    /**
//     *  Handling the case of the stopped app or forgotten recording,
//     *  the start and end times will be the same.j
//     *
//     *  If the start time and end time are not the same, then we do not have an unfinished
//     *  recording.
//     */
//    private suspend fun getRecentPostFromDatabase(): PostTable? {
//        var night = postDatabase.getRecentPost()
//        if (night?.endTimeMilli != night?.startTimeMilli) {
//            night = null
//        }
//        return night
//    }
//
//    private suspend fun clear() {
//        postDatabase.clear()
//    }
//
//    private suspend fun update(night: PostTable) {
//        postDatabase.update(night)
//    }
//
//    private suspend fun insert(night: PostTable) {
//        postDatabase.insert(night)
//    }
//
//    /**
//     * Executes when the START button is clicked.
//     */
//    fun onStartTracking() {
//        viewModelScope.launch {
//            // Create a new night, which captures the current time,
//            // and insert it into the database.
//            val newNight = PostTable()
//
//            insert(newNight)
//
//            tonight.value = getRecentPostFromDatabase()
//        }
//    }
//
//    /**
//     * Executes when the STOP button is clicked.
//     */
//    fun onStopTracking() {
//        viewModelScope.launch {
//            // In Kotlin, the return@label syntax is used for specifying which function among
//            // several nested ones this statement returns from.
//            // In this case, we are specifying to return from launch(),
//            // not the lambda.
//            val oldNight = tonight.value ?: return@launch
//
//            // Update the night in the database to add the end time.
//            oldNight.endTimeMilli = System.currentTimeMillis()
//
//            update(oldNight)
//
//            // Set state to navigate to the SleepQualityFragment.
//            _navigateToSleepQuality.value = oldNight
//        }
//    }
//
//    /**
//     * Executes when the CLEAR button is clicked.
//     */
//    fun onClear() {
//        viewModelScope.launch {
//            // Clear the database table.
//            clear()
//
//            // And clear tonight since it's no longer in the database
//            tonight.value = null
//        }
//
//        // Show a snackbar message, because it's friendly.
//        _showSnackbarEvent.value = true
//    }
//
//}
//
//
