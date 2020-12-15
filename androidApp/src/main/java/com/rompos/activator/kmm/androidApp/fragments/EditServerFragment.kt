package com.rompos.activator.kmm.androidApp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.rompos.activator.kmm.androidApp.R
import com.rompos.activator.kmm.androidApp.Utils
import com.rompos.activator.kmm.androidApp.activities.MainActivity
import com.rompos.activator.kmm.androidApp.databinding.FragmentEditServerBinding
import com.rompos.activator.kmm.shared.base.myApp
import com.rompos.activator.kmm.shared.model.ServerFormViewModel
import com.rompos.activator.kmm.shared.repository.ServersRepository
import dev.icerock.moko.mvvm.getViewModel
import kotlinx.coroutines.launch
import org.kodein.di.instance

const val EDIT_MODEL = "editModel"
const val EDIT_MODEL_ID = "editModelId"

open class EditServerFragment : Fragment() {

    private var _viewBinding: FragmentEditServerBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val repository: ServersRepository by myApp.kodein.instance()
    private var serverFormViewModel = ServerFormViewModel()
//    private var serverFormViewModel: ServerFormViewModel by viewModels()
//    private val serverFormViewModel: ServerFormViewModel? = null
    private var serverId: Long = 0

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        serverFormViewModel = activity?.run {
//            ViewModelProviders.of(this)[ServerFormViewModel::class.java]
//        } ?: throw Exception("Invalid Activity")
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentEditServerBinding.inflate(inflater, container, false)
        val view = viewBinding.root

//        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ServerFormViewModel::class.java)
//        val viewModel = ViewModelProvider(this).get(ServerFormViewModel::class.java)

        val dataBinding : FragmentEditServerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_server, container, false)
//        dataBinding.item = serverFormViewModel

        dataBinding.lifecycleOwner = this
//        serverFormViewModel = getViewModel()
        dataBinding.item = serverFormViewModel

        // Dispatcher Back Step to Main
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                toMain()
            }
        })

        if (arguments?.getLong("ID") != null) {
            serverId = arguments?.getLong("ID")!!
        }

        // Set title
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.edit_server)
        }

        if (serverId > 0) {
            lifecycleScope.launch {
                viewBinding.progressBar.visibility = View.VISIBLE
                repository.get(serverId).let { server ->
                    serverFormViewModel.setForm(server)
                }
            }.also {
                viewBinding.progressBar.visibility = View.GONE
            }
        }

        dataBinding.item = serverFormViewModel

        viewBinding.cancelBtn.setOnClickListener {
            toMain()
        }

        viewBinding.saveBtn.setOnClickListener {
            if (serverFormViewModel.isFormValid()) {
                lifecycleScope.launch {
                    saveRecord(serverFormViewModel)
                    requireActivity().run {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                }.also {
                    toMain()
                }
            } else {
                Utils.snackMsg(view, getString(R.string.error_empty_field))
                println("EMPTY")
            }
        }

        return viewBinding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong(EDIT_MODEL_ID, serverId)
        outState.putParcelable(EDIT_MODEL, serverFormViewModel.getModel())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            serverId = savedInstanceState.getLong(EDIT_MODEL_ID)
            serverFormViewModel.setForm(savedInstanceState.getParcelable(EDIT_MODEL)!!)
        }
    }

    private fun saveRecord(viewModel: ServerFormViewModel) {
        viewBinding.progressBar.visibility = View.VISIBLE
        try {
            repository.save(serverId, viewModel.getModel(serverId))
            toMain()
        } catch (e: Exception) {
            view?.let { Utils.snackMsg(it, e.message.toString()) }
        } finally {
            viewBinding.progressBar.visibility = View.GONE
        }
    }

    private fun toMain() {
        requireActivity().run {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}