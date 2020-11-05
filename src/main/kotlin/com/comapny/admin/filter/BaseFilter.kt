package com.comapny.admin.filter

import org.springframework.stereotype.Component
import org.springframework.web.server.WebFilter

@Component
abstract class BaseFilter : WebFilter {
    companion object {
        fun isBasicResources(path: String): Boolean {
            val basicRegex = "^*.*(json\$|ico\$)".toRegex()
            val resourceRegex =
                "^(?!/warmup|/logging-api|/api|/login|/monitor|/l|/m)/.*/[\\w\\-]+.*(css\$|js\$|json\$|jpg\$|png\$|woff\$|woff2\$|map\$|svg\$)".toRegex()
            if (basicRegex.matches(path)) {
                return true
            }
            if (resourceRegex.matches(path)) {
                return true
            }
            return false
        }

        fun isNoPageRequest(path: String): Boolean {
            val noPageRegex = "^(/warmup|/internal-api|/logging-api|/api|/monitor)/*.*".toRegex()
            if (noPageRegex.matches(path)) {
                return true
            }
            return false
        }
    }
}
