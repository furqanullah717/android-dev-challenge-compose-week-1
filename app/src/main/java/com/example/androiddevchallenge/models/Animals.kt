import com.google.gson.annotations.SerializedName
import java.io.Serializable

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Animals (

	@SerializedName("id") val id : Int,
	@SerializedName("organization_id") val organization_id : String,
	@SerializedName("url") val url : String,
	@SerializedName("type") val type : String,
	@SerializedName("species") val species : String,
	@SerializedName("breeds") val breeds : Breeds,
	@SerializedName("colors") val colors : Colors,
	@SerializedName("age") val age : String,
	@SerializedName("gender") val gender : String,
	@SerializedName("size") val size : String,
	@SerializedName("coat") val coat : String,
	@SerializedName("attributes") val attributes : Attributes,
	@SerializedName("environment") val environment : Environment,
	@SerializedName("tags") val tags : List<String>,
	@SerializedName("name") val name : String,
	@SerializedName("description") val description : String,
	@SerializedName("organization_animal_id") val organization_animal_id : String,
	@SerializedName("photos") val photos : List<Photos>,
	@SerializedName("primary_photo_cropped") val primary_photo_cropped : Primary_photo_cropped?,
	@SerializedName("videos") val videos : List<String>,
	@SerializedName("status") val status : String,
	@SerializedName("status_changed_at") val status_changed_at : String,
	@SerializedName("published_at") val published_at : String,
	@SerializedName("distance") val distance : String,
	@SerializedName("contact") val contact : Contact,
	@SerializedName("_links") val _links : _links
): Serializable