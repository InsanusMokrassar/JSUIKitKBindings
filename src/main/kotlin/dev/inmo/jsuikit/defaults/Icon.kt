package dev.inmo.jsuikit.defaults

import androidx.compose.runtime.Composable
import dev.inmo.jsuikit.defaults.modifers.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.events.Event

sealed class Icon(val name: String) {
    sealed class App(iconName: String) : Icon(iconName) {
        object Home : App("home")
        sealed class Sign(iconName: String) : App("sign-$iconName") {
            object In : Sign("in")
            object Out : Sign("out")
        }
        object User : App("user")
        object Users : App("users")
        object Lock : App("lock")
        object Unlock : App("unlock")
        object Settings : App("settings")
        object Cog : App("cog")
        object Nut : App("nut")
        object Comment : App("comment")
        object Commenting : App("commenting")
        object Comments : App("comments")
        object Hashtag : App("hashtag")
        object Tag : App("tag")
        object Cart : App("cart")
        object Bag : App("bag")
        sealed class Credit(iconName: String) : App("credit-$iconName") {
            object Card : Credit("card")
        }
        object Mail : App("mail")
        object Receiver : App("receiver")
        object Print : App("print")
        object Search : App("search")
        object Location : App("location")
        object Bookmark : App("bookmark")
        object Code : App("code")
        sealed class Paint(iconName: String) : App("paint-$iconName") {
            object Bucket : Paint("bucket")
        }
        object Camera : App("camera")
        sealed class Video(iconName: String) : App("video-$iconName") {
            object Camera : Video("camera")
        }
        object Bell : App("bell")
        object Microphone : App("microphone")
        object Bolt : App("bolt")
        object Star : App("star")
        object Heart : App("heart")
        object Happy : App("happy")
        object Lifesaver : App("lifesaver")
        object Rss : App("rss")
        object Social : App("social")
        sealed class Git(iconName: String) : App("git-$iconName") {
            object Branch : Git("branch")
            object Fork : Git("fork")
        }
        object World : App("world")
        object Calendar : App("calendar")
        object Clock : App("clock")
        object History : App("history")
        object Future : App("future")
        object Pencil : App("pencil")
        object Trash : App("trash")
        object Move : App("move")
        object Link : App("link")
        object Question : App("question")
        object Info : App("info")
        object Warning : App("warning")
        object Image : App("image")
        object Thumbnails : App("thumbnails")
        object Table : App("table")
        object List : App("list")
        object Menu : App("menu")
        object Grid : App("grid")
        sealed class More(iconName: String) : App("more${iconName.takeIf { it.isNotEmpty() } ?.let { "-$it" } ?: "" }") {
            object Vertical : More("vertical")
            companion object : More("more")
        }
        sealed class Plus(iconName: String) : App("plus${iconName.takeIf { it.isNotEmpty() } ?.let { "-$it" } ?: "" }") {
            object Circle : Plus("circle")
            companion object : Plus("plus")
        }
        sealed class Minus(iconName: String) : App("minus${iconName.takeIf { it.isNotEmpty() } ?.let { "-$it" } ?: "" }") {
            object Circle : Minus("circle")
            companion object : Minus("minus")
        }
        object Close : App("close")
        object Check : App("check")
        object Ban : App("ban")
        object Refresh : App("refresh")
        sealed class Play(iconName: String) : App("play${iconName.takeIf { it.isNotEmpty() } ?.let { "-$it" } ?: "" }") {
            object Circle : Play("circle")
            companion object : Play("play")
        }
    }
    sealed class Devices(iconName: String) : Icon(iconName) {
        object Tv : Devices("tv")
        object Desktop : Devices("desktop")
        object Laptop : Devices("laptop")
        sealed class Tablet(iconName: String) : Devices("tablet${iconName.takeIf { it.isNotEmpty() } ?.let { "-$it" } ?: "" }") {
            object Landscape : Tablet("landscape")
            companion object : Tablet("tablet")
        }
        sealed class Phone(iconName: String) : Devices("phone${iconName.takeIf { it.isNotEmpty() } ?.let { "-$it" } ?: "" }") {
            object Landscape : Phone("landscape")
            companion object : Phone("phone")
        }
    }
    sealed class Storage(iconName: String) : Icon(iconName) {
        sealed class File(iconName: String) : Storage("file${iconName.takeIf { it.isNotEmpty() } ?.let { "-$it" } ?: "" }") {
            object Text : File("text")
            object Pdf : File("pdf")
            object Edit : File("edit")
            companion object : File("file")
        }
        object Copy : Storage("copy")
        object Folder : Storage("folder")
        object Album : Storage("album")
        object Push : Storage("push")
        object Pull : Storage("pull")
        object Server : Storage("server")
        object Database : Storage("database")
        sealed class Cloud(iconName: String) : Storage("cloud-$iconName") {
            object Upload : Cloud("upload")
            object Download : Cloud("download")
        }
        object Download : Storage("download")
        object Upload : Storage("upload")
    }
    sealed class Direction(iconName: String) : Icon(iconName) {
        object Reply : Direction("reply")
        object Forward : Direction("forward")
        object Expand : Direction("expand")
        object Shrink : Direction("shrink")
        sealed class Arrow(iconName: String) : Direction("arrow-$iconName") {
            object Up : Arrow("up")
            object Down : Arrow("down")
            object Left : Arrow("left")
            object Right : Arrow("right")
        }
        sealed class Chevron(iconName: String) : Direction("chevron-$iconName") {
            object Up : Chevron("up")
            object Down : Chevron("down")
            object Left : Chevron("left")
            object Right : Chevron("right")
            sealed class Double(iconName: String) : Chevron("double-$iconName") {
                object Left : Double("left")
                object Right : Double("right")
            }
        }
        sealed class Triangle(iconName: String) : Direction("triangle-$iconName") {
            object Up : Triangle("up")
            object Down : Triangle("down")
            object Left : Triangle("left")
            object Right : Triangle("right")
        }
    }
    sealed class Editor(iconName: String) : Icon(iconName) {
        object Bold : Editor("bold")
        object Italic : Editor("italic")
        object Strikethrough : Editor("strikethrough")
        sealed class Quote(iconName: String) : Editor("quote-$iconName") {
            object Right : Quote("right")
        }
    }
    sealed class Brands(iconName: String) : Icon(iconName) {
        object _500px : Brands("500px")
        object Behance : Brands("behance")
        object Discord : Brands("discord")
        object Dribbble : Brands("dribbble")
        object Etsy : Brands("etsy")
        object Facebook : Brands("facebook")
        object Flickr : Brands("flickr")
        object Foursquare : Brands("foursquare")
        sealed class Github(iconName: String) : Brands("github${iconName.takeIf { it.isNotEmpty() } ?.let { "-$it" } ?: "" }") {
            object Alt : Github("alt")
            companion object : Github("github")
        }
        object Gitter : Brands("gitter")
        object Google : Brands("google")
        object Instagram : Brands("instagram")
        object Joomla : Brands("joomla")
        object Linkedin : Brands("linkedin")
        object Pagekit : Brands("pagekit")
        object Pinterest : Brands("pinterest")
        object Reddit : Brands("reddit")
        object Soundcloud : Brands("soundcloud")
        object Tiktok : Brands("tiktok")
        object Tripadvisor : Brands("tripadvisor")
        object Tumblr : Brands("tumblr")
        object Twitch : Brands("twitch")
        object Twitter : Brands("twitter")
        object Uikit : Brands("uikit")
        object Vimeo : Brands("vimeo")
        object Whatsapp : Brands("whatsapp")
        object Wordpress : Brands("wordpress")
        object Xing : Brands("xing")
        object Yelp : Brands("yelp")
        object Youtube : Brands("youtube")
    }

    @Composable
    operator fun invoke(
        vararg modifier: UIKitModifier,
        type: UIKitIconType = UIKitIconType.Default,
        ratio: Float? = null,
        onClick: ((Event) -> Unit)? = null
    ) {
        if (type == UIKitIconType.Button) {
            Button(
                {
                    classes("uk-icon")
                    include(*modifier, type)
                    attr("uk-icon", "icon: $name${if (ratio != null) { "; ratio: $ratio" } else ""}")
                    onClick ?.let { _ ->
                        onClick { onClick(it.nativeEvent) }
                    }
                }
            )
        } else {
            Span(
                {
                    classes("uk-icon")
                    include(*modifier, type)
                    attr("uk-icon", "icon: $name${if (ratio != null) { "; ratio: $ratio" } else ""}")
                    onClick ?.let { _ ->
                        onClick { onClick(it.nativeEvent) }
                    }
                }
            )
        }
    }

    @Composable
    fun drawAsButton(
        vararg modifier: UIKitModifier,
        ratio: Float? = null,
        onClick: ((Event) -> Unit)? = null
    ) = invoke(*modifier, type = UIKitIconType.Button, ratio = ratio, onClick = onClick)

    @Composable
    fun drawAsIcon(
        vararg modifier: UIKitModifier,
        ratio: Float? = null,
        onClick: ((Event) -> Unit)? = null
    ) = invoke(*modifier, type = UIKitIconType.Default, ratio = ratio, onClick = onClick)
}
