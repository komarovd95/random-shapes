package ru.ifmo.random.shapes.examples

import ru.ifmo.random.shapes.api.*
import java.awt.image.BufferedImage

class ExampleRandomShape(
    private val shape: RandomShape<Point>,
    private val samplesCount: Int
) : RandomShape<BufferedImage> by CachedRandomShape(
    ProfilingRandomShape(
        ImageShape(
            ProfilingRandomShape(
                NormalizedRandomShape(
                    ProfilingRandomShape(
                        BoostedRandomShape(
                            ProfilingRandomShape(
                                ClusteredRandomShape(
                                    ProfilingRandomShape(
                                        SampledRandomShape(
                                            shape,
                                            samplesCount
                                        ),
                                        "sampling"
                                    )
                                ),
                                "clustering"
                            ),
                            1.0
                        ),
                        "boosting"
                    )
                ),
                "normalizing"
            ),
            600,
            600
        ),
        "drawing"
    )
)
