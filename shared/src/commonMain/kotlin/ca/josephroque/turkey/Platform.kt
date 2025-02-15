package ca.josephroque.turkey

interface Platform {
	val name: String
}

expect fun getPlatform(): Platform
