package io.legado.app.ui.book.read.config

import android.app.Application
import io.legado.app.App
import io.legado.app.base.BaseViewModel
import io.legado.app.data.entities.TxtTocRule
import io.legado.app.model.localBook.AnalyzeTxtFile

class TocRegexViewModel(application: Application) : BaseViewModel(application) {

    fun saveRule(rule: TxtTocRule, oldRule: TxtTocRule? = null) {
        execute {
            if (rule.serialNumber < 0) {
                rule.serialNumber = App.db.txtTocRule().lastOrderNum + 1
            }
            oldRule?.let {
                App.db.txtTocRule().delete(oldRule)
            }
            App.db.txtTocRule().insert(rule)
        }
    }

    fun importDefault() {
        execute {
            AnalyzeTxtFile.getDefaultRules().let {
                App.db.txtTocRule().insert(*it.toTypedArray())
            }
        }
    }

    fun importOnLine(url: String, finally: (msg: String) -> Unit) {
        execute {

        }.onFinally {

        }
    }

}