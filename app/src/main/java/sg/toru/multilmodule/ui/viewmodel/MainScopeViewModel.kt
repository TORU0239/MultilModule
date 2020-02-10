package sg.toru.multilmodule.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainScopeViewModel: ViewModel() {
    init {
        viewModelScope.launch {
            // Job ongoing will be also cancelled if this viewmodel is cleared.z
        }
    }
}