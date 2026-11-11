package com.example.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.model.AppStrings
import com.example.model.UserProfile
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

private data class ConfettiParticle(
    val initialX: Float,
    val initialY: Float,
    val velocityX: Float,
    val velocityY: Float,
    val color: Color,
    val sizeWidth: Float,
    val sizeHeight: Float,
    val rotationSpeed: Float,
    val isCircle: Boolean,
    val isRibbon: Boolean
)

@Composable
fun StreakCelebrationModal(
    userProfile: UserProfile,
    xpGained: Int = 50,
    onDismiss: () -> Unit,
    onContinue: () -> Unit = onDismiss
) {
    val uiLang = userProfile.uiLanguage
    var burstTrigger by remember { mutableStateOf(0) }

    // Dialog covering the whole window with edge-to-edge support
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.72f))
                .testTag("streak_celebration_dialog"),
            contentAlignment = Alignment.Center
        ) {
            // Background Confetti Burst Animation Layer
            ConfettiExplosionLayer(burstTrigger = burstTrigger)

            // Central Pop-up Celebratory Card
            CelebrationCard(
                userProfile = userProfile,
                xpGained = xpGained,
                uiLang = uiLang,
                onReplayBurst = { burstTrigger++ },
                onClose = onDismiss,
                onContinue = onContinue
            )
        }
    }
}

@Composable
private fun CelebrationCard(
    userProfile: UserProfile,
    xpGained: Int,
    uiLang: String,
    onReplayBurst: () -> Unit,
    onClose: () -> Unit,
    onContinue: () -> Unit
) {
    // Spring pop-in scale for the main card
    val cardScale = remember { Animatable(0.2f) }
    LaunchedEffect(Unit) {
        cardScale.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    }

    // Flame Mascot breathing & wobble animation
    val infiniteTransition = rememberInfiniteTransition(label = "mascot_anim")
    val flameSquishY by infiniteTransition.animateFloat(
        initialValue = 0.96f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(550, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flameSquishY"
    )
    val flameSquishX by infiniteTransition.animateFloat(
        initialValue = 1.04f,
        targetValue = 0.96f,
        animationSpec = infiniteRepeatable(
            animation = tween(550, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flameSquishX"
    )
    val flameWobble by infiniteTransition.animateFloat(
        initialValue = -5f,
        targetValue = 5f,
        animationSpec = infiniteRepeatable(
            animation = tween(700, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "flameWobble"
    )

    // Sunburst rotation
    val sunburstRotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(16000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "sunburstRotation"
    )

    // Glowing aura expanding pulse
    val auraPulse by infiniteTransition.animateFloat(
        initialValue = 0.85f,
        targetValue = 1.25f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "auraPulse"
    )
    val auraAlpha by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "auraAlpha"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth(0.92f)
            .scale(cardScale.value)
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        // Chunky 3D Shadow Card Underlay
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 6.dp),
            shape = RoundedCornerShape(32.dp),
            color = Color(0xFF1E293B)
        ) {
            Box(modifier = Modifier.height(520.dp))
        }

        // Main Card Surface
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .border(3.dp, Color(0xFFFF9600), RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 12.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Top close icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = onClose,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f))
                            .testTag("close_streak_modal_btn")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                // MASCOT FLAME WITH SUNBURST & AURA
                Box(
                    modifier = Modifier
                        .size(190.dp)
                        .clickable { onReplayBurst() },
                    contentAlignment = Alignment.Center
                ) {
                    // Sunburst rays rotating
                    SunburstRays(rotation = sunburstRotation)

                    // Expanding fiery aura rings
                    Box(
                        modifier = Modifier
                            .size(140.dp)
                            .scale(auraPulse)
                            .clip(CircleShape)
                            .border(3.dp, Color(0xFFFF9600).copy(alpha = auraAlpha), CircleShape)
                    )

                    // Mascot Animated Flame Canvas
                    Box(
                        modifier = Modifier
                            .size(130.dp)
                            .scale(flameSquishX, flameSquishY)
                            .rotate(flameWobble),
                        contentAlignment = Alignment.Center
                    ) {
                        PlayfulFlameMascot()
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // CHUNKY "STREAK EXTENDED!" BADGE
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFFF9600),
                    border = androidx.compose.foundation.BorderStroke(2.dp, Color(0xFFCC7700)),
                    shadowElevation = 3.dp
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocalFireDepartment,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "STREAK EXTENDED!",
                            fontWeight = FontWeight.Black,
                            fontSize = 13.sp,
                            color = Color.White,
                            letterSpacing = 1.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // NUMBER OF DAYS
                Text(
                    text = "${userProfile.streakDays} DAYS!",
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFFFF7A00),
                    letterSpacing = (-0.5).sp
                )

                // Subtitle in target/ui language
                val celebrationText = when (uiLang) {
                    "ur" -> "شاباش! آج کا سبق مکمل ہوا اور آپ کی سٹریک محفوظ ہو گئی۔"
                    "ur_roman" -> "Shabash! Aaj ka sabaq mukammal hua aur streak barh gayi!"
                    else -> "You're on fire! You completed today's lesson and kept your momentum."
                }
                Text(
                    text = celebrationText,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                Spacer(modifier = Modifier.height(14.dp))

                // MINI 7-DAY ROW
                Mini7DayStreakPills(userProfile = userProfile)

                Spacer(modifier = Modifier.height(14.dp))

                // REWARD XP CHIP
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = DuolingoYellowLight,
                    border = androidx.compose.foundation.BorderStroke(1.5.dp, DuolingoYellowShadow),
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 7.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFD97706),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "+$xpGained XP BONUS EARNED",
                            fontWeight = FontWeight.Black,
                            fontSize = 12.sp,
                            color = Color(0xFF78350F)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // CHUNKY 3D CONTINUE BUTTON
                ChunkyButton(
                    onClick = onContinue,
                    colorStyle = ChunkyButtonColor.GREEN,
                    modifier = Modifier.fillMaxWidth(),
                    testTag = "celebrate_continue_button"
                ) {
                    Text(
                        text = if (uiLang == "ur") "جاری رکھیں (Continue)" else if (uiLang == "ur_roman") "Jaari Rakhein (Continue)" else "CONTINUE 🎉",
                        fontWeight = FontWeight.Black,
                        fontSize = 15.sp,
                        letterSpacing = 0.5.sp
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Replay burst text link
                TextButton(
                    onClick = onReplayBurst,
                    modifier = Modifier.testTag("replay_burst_btn")
                ) {
                    Text(
                        text = "🎊 Tap to celebrate again!",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = DuolingoBlue
                    )
                }
            }
        }
    }
}

@Composable
private fun SunburstRays(rotation: Float) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .rotate(rotation)
    ) {
        val center = Offset(size.width / 2f, size.height / 2f)
        val radius = size.minDimension / 1.8f
        val rayCount = 12
        val sweepAngle = 360f / rayCount

        for (i in 0 until rayCount) {
            val startAngle = i * sweepAngle
            val path = Path().apply {
                moveTo(center.x, center.y)
                val angleRad1 = Math.toRadians((startAngle - sweepAngle / 4).toDouble())
                val angleRad2 = Math.toRadians((startAngle + sweepAngle / 4).toDouble())

                lineTo(
                    center.x + (radius * cos(angleRad1)).toFloat(),
                    center.y + (radius * sin(angleRad1)).toFloat()
                )
                lineTo(
                    center.x + (radius * cos(angleRad2)).toFloat(),
                    center.y + (radius * sin(angleRad2)).toFloat()
                )
                close()
            }

            drawPath(
                path = path,
                color = if (i % 2 == 0) Color(0xFFFFB800).copy(alpha = 0.22f) else Color(0xFFFF9600).copy(alpha = 0.12f),
                style = Fill
            )
        }
    }
}

@Composable
private fun PlayfulFlameMascot() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        val centerX = width / 2f
        val centerY = height / 2f

        // Outer Flame Body (Teardrop shape with fiery curves)
        val outerFlamePath = Path().apply {
            moveTo(centerX, height * 0.05f) // Tip of the fire
            cubicTo(
                width * 0.95f, height * 0.35f,
                width * 1.05f, height * 0.85f,
                centerX, height * 0.98f
            )
            cubicTo(
                width * -0.05f, height * 0.85f,
                width * 0.05f, height * 0.35f,
                centerX, height * 0.05f
            )
            close()
        }

        // Draw Outer Fiery Gradient
        drawPath(
            path = outerFlamePath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFB703),
                    Color(0xFFFB8500),
                    Color(0xFFE63946)
                ),
                startY = 0f,
                endY = height
            )
        )

        // Draw 3D-styled Dark Border
        drawPath(
            path = outerFlamePath,
            color = Color(0xFFC1121F),
            style = Stroke(width = 8f)
        )

        // Inner Golden Flame Core
        val innerFlamePath = Path().apply {
            moveTo(centerX, height * 0.38f)
            cubicTo(
                width * 0.82f, height * 0.58f,
                width * 0.78f, height * 0.88f,
                centerX, height * 0.92f
            )
            cubicTo(
                width * 0.22f, height * 0.88f,
                width * 0.18f, height * 0.58f,
                centerX, height * 0.38f
            )
            close()
        }

        drawPath(
            path = innerFlamePath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFF275),
                    Color(0xFFFFD166)
                )
            )
        )

        // Cartoon Mascot Eyes! (Playful & Joyful)
        val eyeRadiusX = width * 0.07f
        val eyeRadiusY = height * 0.09f
        val leftEyeCenter = Offset(centerX - width * 0.15f, centerY + height * 0.08f)
        val rightEyeCenter = Offset(centerX + width * 0.15f, centerY + height * 0.08f)

        // Sclera / eye background (white)
        drawOval(
            color = Color.White,
            topLeft = Offset(leftEyeCenter.x - eyeRadiusX, leftEyeCenter.y - eyeRadiusY),
            size = Size(eyeRadiusX * 2f, eyeRadiusY * 2f)
        )
        drawOval(
            color = Color.White,
            topLeft = Offset(rightEyeCenter.x - eyeRadiusX, rightEyeCenter.y - eyeRadiusY),
            size = Size(eyeRadiusX * 2f, eyeRadiusY * 2f)
        )

        // Pupils (black)
        val pupilRadius = eyeRadiusX * 0.65f
        drawCircle(
            color = Color(0xFF1E293B),
            radius = pupilRadius,
            center = leftEyeCenter
        )
        drawCircle(
            color = Color(0xFF1E293B),
            radius = pupilRadius,
            center = rightEyeCenter
        )

        // Cute white specular twinkle highlights in eyes
        drawCircle(
            color = Color.White,
            radius = pupilRadius * 0.4f,
            center = Offset(leftEyeCenter.x - pupilRadius * 0.3f, leftEyeCenter.y - pupilRadius * 0.3f)
        )
        drawCircle(
            color = Color.White,
            radius = pupilRadius * 0.4f,
            center = Offset(rightEyeCenter.x - pupilRadius * 0.3f, rightEyeCenter.y - pupilRadius * 0.3f)
        )

        // Joyful Cartoon Smile Curve
        val smilePath = Path().apply {
            moveTo(centerX - width * 0.12f, centerY + height * 0.22f)
            quadraticTo(
                centerX, centerY + height * 0.32f,
                centerX + width * 0.12f, centerY + height * 0.22f
            )
        }
        drawPath(
            path = smilePath,
            color = Color(0xFF1E293B),
            style = Stroke(width = 6f, cap = androidx.compose.ui.graphics.StrokeCap.Round)
        )

        // Rosy Cheeks
        drawCircle(
            color = Color(0xFFFF5D8F).copy(alpha = 0.55f),
            radius = width * 0.06f,
            center = Offset(centerX - width * 0.26f, centerY + height * 0.18f)
        )
        drawCircle(
            color = Color(0xFFFF5D8F).copy(alpha = 0.55f),
            radius = width * 0.06f,
            center = Offset(centerX + width * 0.26f, centerY + height * 0.18f)
        )
    }
}

@Composable
private fun Mini7DayStreakPills(userProfile: UserProfile) {
    val activityList = remember(userProfile.studiedDates) {
        userProfile.getLast7DaysActivity()
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        activityList.forEach { dayActivity ->
            val isDone = dayActivity.isStudied
            val isToday = dayActivity.isToday

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = dayActivity.dayName,
                    fontSize = 10.sp,
                    fontWeight = if (isToday) FontWeight.Black else FontWeight.Bold,
                    color = if (isToday) Color(0xFFFF7A00) else MaterialTheme.colorScheme.onSurfaceVariant
                )

                Surface(
                    shape = CircleShape,
                    color = if (isDone) Color(0xFFFF9600) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                    border = if (isToday) androidx.compose.foundation.BorderStroke(2.dp, Color(0xFFFF7A00)) else null,
                    modifier = Modifier.size(34.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        if (isDone) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "Done",
                                tint = Color.White,
                                modifier = Modifier.size(18.dp)
                            )
                        } else {
                            Text(
                                text = "·",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ConfettiExplosionLayer(burstTrigger: Int) {
    // Generate 50 particles on each burst trigger
    val particles = remember(burstTrigger) {
        val colors = listOf(
            DuolingoGreen,
            DuolingoOrange,
            DuolingoBlue,
            DuolingoYellow,
            DuolingoRed,
            Color(0xFFFF007A),
            Color(0xFFFFD700),
            Color(0xFF00E5FF)
        )
        List(55) {
            val angle = Random.nextFloat() * 2f * Math.PI.toFloat()
            val speed = Random.nextFloat() * 850f + 350f
            val vx = (cos(angle) * speed)
            // Bias upwards like a celebratory cannon
            val vy = (sin(angle) * speed) - Random.nextFloat() * 400f

            ConfettiParticle(
                initialX = 0f,
                initialY = 0f,
                velocityX = vx,
                velocityY = vy,
                color = colors[Random.nextInt(colors.size)],
                sizeWidth = Random.nextFloat() * 12f + 8f,
                sizeHeight = Random.nextFloat() * 18f + 8f,
                rotationSpeed = (Random.nextFloat() - 0.5f) * 720f,
                isCircle = Random.nextBoolean(),
                isRibbon = Random.nextBoolean()
            )
        }
    }

    // Time ticker for gravity and physics
    val animTime = remember(burstTrigger) { Animatable(0f) }
    LaunchedEffect(burstTrigger) {
        animTime.snapTo(0f)
        animTime.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2800, easing = LinearEasing)
        )
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val t = animTime.value
        val originX = size.width / 2f
        val originY = size.height * 0.38f
        val gravity = 980f

        // Alpha fades gently near the end
        val alpha = if (t > 0.7f) ((1f - t) / 0.3f).coerceIn(0f, 1f) else 1f

        particles.forEach { p ->
            val x = originX + (p.velocityX * t * (size.width / 420f))
            val y = originY + (p.velocityY * t) + (0.5f * gravity * t * t)
            val currentRot = p.rotationSpeed * t

            if (y <= size.height + 50f && x in -50f..(size.width + 50f)) {
                val particleColor = p.color.copy(alpha = alpha)

                if (p.isCircle) {
                    drawCircle(
                        color = particleColor,
                        radius = p.sizeWidth / 2f,
                        center = Offset(x, y)
                    )
                } else {
                    // Draw rotated rectangle or ribbon
                    drawRect(
                        color = particleColor,
                        topLeft = Offset(x - p.sizeWidth / 2f, y - p.sizeHeight / 2f),
                        size = Size(p.sizeWidth, p.sizeHeight)
                    )
                }
            }
        }
    }
}
