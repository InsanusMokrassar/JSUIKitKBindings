val src = """App
home
sign-in
sign-out
user
users
lock
unlock
settings
cog
nut
comment
commenting
comments
hashtag
tag
cart
bag
credit-card
mail
receiver
print
search
location
bookmark
code
paint-bucket
camera
video-camera
bell
microphone
bolt
star
heart
happy
lifesaver
rss
social
git-branch
git-fork
world
calendar
clock
history
future
pencil
trash
move
link
question
info
warning
image
thumbnails
table
list
menu
grid
more
more-vertical
plus
plus-circle
minus
minus-circle
close
check
ban
refresh
play
play-circle
Devices
tv
desktop
laptop
tablet
phone
tablet-landscape
phone-landscape
Storage
file
file-text
file-pdf
copy
file-edit
folder
album
push
pull
server
database
cloud-upload
cloud-download
download
upload
Direction
reply
forward
expand
shrink
arrow-up
arrow-down
arrow-left
arrow-right
chevron-up
chevron-down
chevron-left
chevron-right
chevron-double-left
chevron-double-right
triangle-up
triangle-down
triangle-left
triangle-right
Editor
bold
italic
strikethrough
quote-right
Brands
500px
behance
discord
dribbble
etsy
facebook
flickr
foursquare
github
github-alt
gitter
google
instagram
joomla
linkedin
pagekit
pinterest
reddit
soundcloud
tiktok
tripadvisor
tumblr
twitch
twitter
uikit
vimeo
whatsapp
wordpress
xing
yelp
youtube"""

data class IconsPart(
    val src: String,
    val subelements: List<IconsPart>,
    val classname: String = src.split("-").joinToString("") { it.replaceFirstChar { it.uppercase() } },
    val isSelfIcon: Boolean = true
) {
    private val prefix = if (subelements.isEmpty()) "object" else "sealed class"
    private val classnameArgs = if (subelements.isEmpty()) "" else "(iconName: String)"
    private val parentClassnameArgs = if (subelements.isEmpty())
        "(\"$src\")" else if (src.first().isLowerCase()) "(\"$src${if (isSelfIcon) "\${iconName.takeIf { it.isNotEmpty() } ?.let { \"-\$it\" } ?: \"\" }" else "-\$iconName" }\")"
    else
        "(iconName)"
    private fun body(linePrefix: String = ""): String {
        val newLinePrefix = "$linePrefix    "
        val postfix = if (isSelfIcon) {
            "${newLinePrefix}companion object : $classname(\"$src\")\n"
        } else {
            ""
        }
        return subelements.takeIf {
            it.isNotEmpty()
        } ?.joinToString("\n", " {\n", "\n$postfix$linePrefix}") {
            it.generateString(this, newLinePrefix)
        } ?: ""
    }

    fun generateString(parent: IconsPart?, linePrefix: String = ""): String {
        return "$linePrefix$prefix $classname$classnameArgs ${parent ?.let { ": ${it.classname}$parentClassnameArgs" } ?: ""}${body(linePrefix)}"
    }
}

class SimpleElement(
    val src: String,
    private val subelements: List<SimpleElement>,
    private val isElement: Boolean
) {
    val allSubelements: List<String> = listOf(src) + subelements.flatMap {
        it.allSubelements.map {
            if (src.first().isLowerCase()) {
                "$src-$it"
            } else {
                it
            }
        }
    }

    fun toIconElement(): IconsPart = IconsPart(
        src,
        subelements.map { it.toIconElement() },
        isSelfIcon = isElement
    )
}

fun split(list: List<String>): SimpleElement {
    val currentSrc = list.first().takeWhile { it != '-' }
    val withoutFirst = list.drop(1)
    val resultSubelements = mutableListOf<SimpleElement>()

    val withoutPrefix = when {
        currentSrc.first().isUpperCase() -> withoutFirst.takeWhile { !it.first().isUpperCase() }
        else -> list.filter { it.startsWith("$currentSrc-") }.map { it.removePrefix("$currentSrc-") }
    }

    var left: List<String> = withoutPrefix

    while (left.isNotEmpty()) {
        val newElement = split(left)

        resultSubelements.add(newElement)

        left = left - (newElement.allSubelements.toSet() + newElement.src)
    }

    return SimpleElement(currentSrc, resultSubelements, currentSrc.first().isLowerCase() && list.any { it.endsWith(currentSrc) })
}

fun main() {
    val splitted = src.split("\n")

    var leftList = splitted
    val resultSubelements = mutableListOf<SimpleElement>()

    while (leftList.isNotEmpty()) {
        val subelement = split(leftList)
        leftList = leftList - (subelement.allSubelements.toSet() + subelement.src)

        resultSubelements.add(subelement)
    }

    val rootElement = SimpleElement("Icon", resultSubelements, false).toIconElement()

    println(rootElement.generateString(null))
}
