package com.jozze.things.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jozze.core.common.Resource
import com.jozze.things.domain.model.Note
import com.jozze.things.domain.model.asRequest
import com.jozze.things.domain.repository.ThingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ThingsRepository): ViewModel() {

//    private val repository: ThingsRepository by lazy {
//        ThingsRepositoryImpl(ApiService.getClient())
//    }

//    private val repository by inject<ThingsRepository>()
//    private val repository = get<ThingsRepository>()


    val thing = MutableStateFlow<Resource<Note>>(Resource.Success(Note("placeholder title", "placeholder text")))
    val things = MutableStateFlow<Resource<List<Note>>>(Resource.Success(listOf(Note("placeholder title", "placeholder text"))))

//    fun getDummyThing() {
//        thing.value = Resource.Loading()
//        viewModelScope.launch {
//            thing.value = Resource.Success((repository.getThing("3") as NoteRequestDto).asNote())
//        }
//    }
//
//    fun getAllThings() {
//        things.value = Resource.Loading()
//        viewModelScope.launch {
//            things.value = Resource.Success(((repository.getAllThings().map { (it as NoteRequestDto).asNote() })))
//
////            things.value = Resource.Success(((repository.getAllThings().map { (it as NoteDto).asNote() })))
////            things.value = Resource.Success(((repository.getAllThings()[0] as NoteDto)).asNote())
//    }
//}
//
//    fun addThing() = flow<Resource<Nothing>> {
//        emit(Resource.Loading())
//        repository.addThing(NoteRequestDto("my first note", "hey! how is it going"))
//        emit(Resource.Loading(loading = false))
//    }

    fun addThing() = flow<Resource<Note>> {
        emit(Resource.Loading())

        viewModelScope.launch {
            repository.addThing(
                Note("some title", "some text message").asRequest()
            )
        }
//        val note = Note("my first note", "hey! how is it going")
//        repository.addThing(object : ThingDto<Note>() {
//            override val name: String
//                get() = note.title
//            override val data: Note
//                get() = note
//        }.also {
//            println("""
//                ${it.name}
//                ${it.data.body}
//            """.trimIndent())
//        })

//        viewModelScope.launch {
//            ApiService.getClient().post<NoteDto> {
//                url(ApiConstants.BASE_URL)
//
//                body = Note(
//                    "title ${(System.currentTimeMillis()/79992349).toInt()}",
//                    "body text wrote at ${System.currentTimeMillis()}"
//                ).asRequest().also {
//                    log("""
//                        ${it.name}
//                        ${it.data}
//                    """.trimIndent())
//                }
//
////                body = NoteRequestDto("title 1", "body 1")
////                    .also {
////                        log("""
////                            ${it.name}
////                            ${it.data}
////                    """.trimIndent())
////                    }
//            }
//        }
//        emit(Resource.Loading(loading = false))
    }

    fun getAllThings() = flow<Resource<Note>> {
        emit(Resource.Loading())
//        repository.getAllThings<Note>()
//        viewModelScope.launch {
//            ApiService.getClient().get<NoteDto> {
//                url(ApiConstants.BASE_URL)
//            }
//        }
        emit(Resource.Loading(loading = false))
    }

}