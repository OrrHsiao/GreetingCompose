package org.xiaoao.greetingcompose

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform