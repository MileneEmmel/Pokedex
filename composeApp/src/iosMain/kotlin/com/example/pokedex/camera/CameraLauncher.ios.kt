package com.example.pokedex.camera

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSHomeDirectory
import platform.UIKit.UIImageJPEGRepresentation
import platform.UIKit.UIImagePickerController
import platform.UIKit.UIImagePickerControllerDelegateProtocol
import platform.UIKit.UIImagePickerControllerOriginalImage
import platform.UIKit.UIImagePickerControllerSourceType
import platform.UIKit.UIApplication
import platform.UIKit.UINavigationControllerDelegateProtocol
import platform.darwin.NSObject
import kotlin.random.Random

private class CameraDelegate : NSObject(), UIImagePickerControllerDelegateProtocol, UINavigationControllerDelegateProtocol {
    var onResult: ((String?) -> Unit)? = null

    override fun imagePickerController(
        picker: UIImagePickerController,
        didFinishPickingMediaWithInfo: Map<Any?, *>
    ) {
        val image = didFinishPickingMediaWithInfo[UIImagePickerControllerOriginalImage]
        val path = if (image != null) {
            val fileName = "pkm_${Random.nextInt(100000, 999999)}.jpg"
            val filePath = "${NSHomeDirectory()}/Documents/$fileName"
            val data = UIImageJPEGRepresentation(image, 0.9)
            data?.writeToFile(filePath, atomically = true)
            filePath
        } else {
            null
        }
        onResult?.invoke(path)
        picker.dismissViewControllerAnimated(true, completion = null)
        onResult = null
    }

    override fun imagePickerControllerDidCancel(picker: UIImagePickerController) {
        onResult?.invoke(null)
        picker.dismissViewControllerAnimated(true, completion = null)
        onResult = null
    }
}

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun rememberCameraLauncher(onResult: (String?) -> Unit): () -> Unit {
    val delegate = remember { CameraDelegate() }

    return {
        delegate.onResult = onResult
        val picker = UIImagePickerController().apply {
            sourceType = UIImagePickerControllerSourceType.UIImagePickerControllerSourceTypeCamera
            setDelegate(delegate)
        }
        val rootViewController = UIApplication.sharedApplication.keyWindow?.rootViewController
        rootViewController?.presentViewController(picker, animated = true, completion = null)
    }
}

