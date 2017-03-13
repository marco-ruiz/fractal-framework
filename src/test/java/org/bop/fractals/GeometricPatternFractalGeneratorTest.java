/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bop.fractals;

import java.util.ArrayList;
import java.util.List;

import org.bop.fractals.line.FractalLine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Marco Ruiz
 * @since Feb 26, 2017
 */
public class GeometricPatternFractalGeneratorTest {

	private List<FractalLine> expected;
	private List<FractalLine> computed = getComputedFractal();

	@Before
	public void setUp() throws Exception {
		expected = getExpectedFractal();
	}

	@Test
	public final void testGetFractal() {
		Assert.assertEquals(expected.size(), computed.size());
		for (FractalLine line : expected)
			computed.remove(line);

		Assert.assertEquals(0, computed.size());
	}

	private final List<FractalLine> getComputedFractal() {
		GeometricPatternFractalGenerator<FractalLine> generator =
				new GeometricPatternFractalGenerator<FractalLine>(getPattern(), 5, false, null);
		return generator.generateFractalSync();
	}

	private final List<FractalLine> getPattern() {
		List<FractalLine> result = new ArrayList<FractalLine>();

		result.add(new FractalLine(337.0f, 536.0f, 312.0f, 257.0f));
		result.add(new FractalLine(310.0f, 364.0f, 338.0f, 191.0f));
		result.add(new FractalLine(321.0f, 497.0f, 151.0f, 456.0f));
		result.add(new FractalLine(345.0f, 496.0f, 492.0f, 395.0f));

		return result;
	}

	private final List<FractalLine> getExpectedFractal() {
		List<FractalLine> result = new ArrayList<FractalLine>();

		result.add(new FractalLine(310.000000f, 364.000000f, 338.000000f, 191.000000f));
		result.add(new FractalLine(321.000000f, 497.000000f, 151.000000f, 456.000000f));
		result.add(new FractalLine(345.000000f, 496.000000f, 492.000000f, 395.000000f));
		result.add(new FractalLine(320.236969f, 255.555283f, 363.970276f, 155.011673f));
		result.add(new FractalLine(213.880188f, 478.577057f, 117.166031f, 427.427063f));
		result.add(new FractalLine(432.004913f, 427.305115f, 536.740540f, 388.815460f));
		result.add(new FractalLine(306.333069f, 337.882904f, 209.618927f, 286.732880f));
		result.add(new FractalLine(294.736176f, 498.664551f, 236.497742f, 591.005188f));
		result.add(new FractalLine(361.643127f, 474.942932f, 331.303558f, 367.812134f));
		result.add(new FractalLine(321.036804f, 340.988983f, 425.772461f, 302.499329f));
		result.add(new FractalLine(298.943481f, 484.270935f, 268.603943f, 377.140137f));
		result.add(new FractalLine(369.692871f, 487.947388f, 471.640564f, 537.971375f));
		result.add(new FractalLine(343.216827f, 191.398285f, 385.280365f, 137.212173f));
		result.add(new FractalLine(151.792542f, 450.839752f, 101.075096f, 404.872437f));
		result.add(new FractalLine(495.373901f, 399.119263f, 564.819458f, 391.986725f));
		result.add(new FractalLine(244.245438f, 310.145569f, 193.528000f, 264.178223f));
		result.add(new FractalLine(262.422546f, 558.331909f, 212.834641f, 605.301636f));
		result.add(new FractalLine(338.413086f, 409.752686f, 336.591705f, 340.115845f));
		result.add(new FractalLine(384.405823f, 312.803131f, 453.851318f, 305.670593f));
		result.add(new FractalLine(275.713470f, 419.080688f, 273.892120f, 349.443848f));
		result.add(new FractalLine(434.979858f, 514.770752f, 489.044098f, 560.864990f));
		result.add(new FractalLine(322.053802f, 239.155594f, 271.336365f, 193.188263f));
		result.add(new FractalLine(197.701279f, 475.523682f, 148.113373f, 522.493408f));
		result.add(new FractalLine(445.351227f, 417.114410f, 443.529877f, 347.477600f));
		result.add(new FractalLine(290.154175f, 334.829529f, 240.566223f, 381.799225f));
		result.add(new FractalLine(290.469208f, 514.529907f, 333.435150f, 567.435425f));
		result.add(new FractalLine(352.517639f, 460.889862f, 283.093903f, 457.412354f));
		result.add(new FractalLine(334.383118f, 330.798279f, 332.561768f, 261.161469f));
		result.add(new FractalLine(289.817993f, 470.217865f, 220.394257f, 466.740326f));
		result.add(new FractalLine(386.574158f, 490.606201f, 436.542542f, 440.316162f));
		result.add(new FractalLine(330.486938f, 243.312881f, 399.932404f, 236.180374f));
		result.add(new FractalLine(202.478180f, 467.448883f, 200.656815f, 397.812103f));
		result.add(new FractalLine(448.219604f, 426.242981f, 502.283844f, 472.337219f));
		result.add(new FractalLine(294.931061f, 326.754700f, 293.109711f, 257.117920f));
		result.add(new FractalLine(282.798035f, 509.163696f, 213.374329f, 505.686157f));
		result.add(new FractalLine(361.818024f, 458.729401f, 411.786438f, 408.439392f));
		result.add(new FractalLine(337.251495f, 339.926880f, 391.315735f, 386.021088f));
		result.add(new FractalLine(299.118408f, 468.057404f, 349.086792f, 417.767395f));
		result.add(new FractalLine(381.872253f, 499.133881f, 385.952789f, 571.322937f));
		result.add(new FractalLine(367.071167f, 156.060059f, 400.951965f, 129.718124f));
		result.add(new FractalLine(118.444649f, 424.421448f, 94.809311f, 388.710632f));
		result.add(new FractalLine(538.148743f, 391.834473f, 581.350708f, 398.252380f));
		result.add(new FractalLine(210.897568f, 283.727264f, 187.262207f, 248.016418f));
		result.add(new FractalLine(233.604416f, 589.504700f, 196.278458f, 610.308167f));
		result.add(new FractalLine(334.414307f, 366.640381f, 344.081451f, 324.143982f));
		result.add(new FractalLine(427.180603f, 305.518341f, 470.382507f, 311.936249f));
		result.add(new FractalLine(271.714691f, 375.968384f, 281.381897f, 333.472015f));
		result.add(new FractalLine(470.408600f, 541.129822f, 496.053162f, 577.435303f));
		result.add(new FractalLine(288.705902f, 212.737289f, 265.070587f, 177.026474f));
		result.add(new FractalLine(168.883148f, 506.696503f, 131.557190f, 527.499939f));
		result.add(new FractalLine(441.352448f, 374.002136f, 451.019653f, 331.505798f));
		result.add(new FractalLine(261.336029f, 366.002319f, 224.010025f, 386.805695f));
		result.add(new FractalLine(319.295654f, 545.570496f, 337.158752f, 584.288391f));
		result.add(new FractalLine(309.319183f, 461.593628f, 267.771606f, 448.747162f));
		result.add(new FractalLine(330.384338f, 287.686005f, 340.051544f, 245.189636f));
		result.add(new FractalLine(246.619537f, 470.921600f, 205.071960f, 458.075104f));
		result.add(new FractalLine(415.491425f, 457.358521f, 453.561646f, 434.601135f));
		result.add(new FractalLine(373.261719f, 236.028122f, 416.463593f, 242.446030f));
		result.add(new FractalLine(198.479385f, 424.336639f, 208.146576f, 381.840271f));
		result.add(new FractalLine(483.648346f, 452.602081f, 509.292908f, 488.907532f));
		result.add(new FractalLine(290.932281f, 283.642456f, 300.599487f, 241.146103f));
		result.add(new FractalLine(239.599609f, 509.867432f, 198.052032f, 497.020935f));
		result.add(new FractalLine(390.735321f, 425.481750f, 428.805542f, 402.724396f));
		result.add(new FractalLine(372.680237f, 366.285950f, 398.324799f, 402.591400f));
		result.add(new FractalLine(328.035675f, 434.809753f, 366.105896f, 412.052399f));
		result.add(new FractalLine(387.377289f, 543.735901f, 378.684875f, 588.128906f));
		result.add(new FractalLine(346.854889f, 181.737625f, 323.219543f, 146.026825f));
		result.add(new FractalLine(142.456985f, 446.486237f, 105.131020f, 467.289673f));
		result.add(new FractalLine(505.040894f, 395.005920f, 514.708069f, 352.509491f));
		result.add(new FractalLine(234.909882f, 305.792023f, 197.583893f, 326.595428f));
		result.add(new FractalLine(257.381836f, 567.289673f, 275.244934f, 606.007507f));
		result.add(new FractalLine(335.054810f, 399.822052f, 293.507233f, 386.975555f));
		result.add(new FractalLine(394.072815f, 308.689789f, 403.739990f, 266.193420f));
		result.add(new FractalLine(272.355225f, 409.150055f, 230.807617f, 396.303558f));
		result.add(new FractalLine(444.802216f, 518.993713f, 482.872437f, 496.236359f));
		result.add(new FractalLine(312.718262f, 234.802063f, 275.392273f, 255.605484f));
		result.add(new FractalLine(192.660583f, 484.481415f, 210.523666f, 523.199280f));
		result.add(new FractalLine(441.992981f, 407.183777f, 400.445374f, 394.337280f));
		result.add(new FractalLine(285.113464f, 343.787262f, 302.976532f, 382.505127f));
		result.add(new FractalLine(298.998840f, 520.225647f, 338.878174f, 505.393707f));
		result.add(new FractalLine(342.382019f, 463.476837f, 326.444366f, 503.838898f));
		result.add(new FractalLine(331.024872f, 320.867645f, 289.477264f, 308.021149f));
		result.add(new FractalLine(279.682373f, 472.804840f, 263.744720f, 513.166870f));
		result.add(new FractalLine(391.521942f, 481.154175f, 371.771271f, 441.547424f));
		result.add(new FractalLine(340.153931f, 239.199539f, 349.821106f, 196.703186f));
		result.add(new FractalLine(199.119919f, 457.518250f, 157.572357f, 444.671753f));
		result.add(new FractalLine(458.041962f, 430.465942f, 496.112183f, 407.708588f));
		result.add(new FractalLine(291.572815f, 316.824066f, 250.025238f, 303.977570f));
		result.add(new FractalLine(272.662415f, 511.750671f, 256.724762f, 552.112732f));
		result.add(new FractalLine(366.765808f, 449.277374f, 347.015167f, 409.670624f));
		result.add(new FractalLine(347.073853f, 344.149841f, 385.144043f, 321.392456f));
		result.add(new FractalLine(304.066193f, 458.605377f, 284.315552f, 418.998657f));
		result.add(new FractalLine(385.668823f, 509.331024f, 429.177490f, 521.351746f));
		result.add(new FractalLine(351.324097f, 185.562256f, 394.526001f, 191.980133f));
		result.add(new FractalLine(146.601807f, 442.330078f, 156.268982f, 399.833710f));
		result.add(new FractalLine(505.367737f, 400.983459f, 531.012390f, 437.288910f));
		result.add(new FractalLine(239.054703f, 301.635864f, 248.721893f, 259.139526f));
		result.add(new FractalLine(253.561508f, 562.850037f, 212.013962f, 550.003601f));
		result.add(new FractalLine(341.027008f, 399.950928f, 379.097229f, 377.193542f));
		result.add(new FractalLine(394.399658f, 314.667328f, 420.044220f, 350.972748f));
		result.add(new FractalLine(278.327393f, 409.278931f, 316.397644f, 386.521545f));
		result.add(new FractalLine(440.632843f, 523.435974f, 431.940399f, 567.829041f));
		result.add(new FractalLine(316.863037f, 230.645920f, 326.530243f, 188.149551f));
		result.add(new FractalLine(188.840240f, 480.041809f, 147.292709f, 467.195313f));
		result.add(new FractalLine(447.965149f, 407.312653f, 486.035370f, 384.555267f));
		result.add(new FractalLine(281.293152f, 339.347656f, 239.745605f, 326.501160f));
		result.add(new FractalLine(294.291443f, 523.689453f, 278.353821f, 564.051453f));
		result.add(new FractalLine(342.963898f, 457.544586f, 323.213226f, 417.937836f));
		result.add(new FractalLine(336.997040f, 320.996521f, 375.067261f, 298.239136f));
		result.add(new FractalLine(280.264252f, 466.872559f, 260.513611f, 427.265839f));
		result.add(new FractalLine(395.625092f, 485.639984f, 439.133789f, 497.660675f));
		result.add(new FractalLine(340.480743f, 245.177063f, 366.125336f, 281.482513f));
		result.add(new FractalLine(205.092102f, 457.647125f, 243.162292f, 434.889771f));
		result.add(new FractalLine(453.872589f, 434.908234f, 445.180145f, 479.301239f));
		result.add(new FractalLine(297.544983f, 316.952942f, 335.615173f, 294.195587f));
		result.add(new FractalLine(273.244293f, 505.818390f, 253.493652f, 466.211670f));
		result.add(new FractalLine(370.868958f, 453.763184f, 414.377655f, 465.783875f));
		result.add(new FractalLine(342.904480f, 348.592133f, 334.212067f, 392.985138f));
		result.add(new FractalLine(308.169342f, 463.091187f, 351.678040f, 475.111877f));
		result.add(new FractalLine(379.468781f, 509.385223f, 340.687927f, 534.193176f));
		result.add(new FractalLine(386.997986f, 138.327347f, 411.611450f, 127.599205f));
		result.add(new FractalLine(102.315125f, 403.248169f, 93.510796f, 377.944000f));
		result.add(new FractalLine(565.206116f, 394.034698f, 590.402954f, 404.607697f));
		result.add(new FractalLine(194.768036f, 262.553986f, 185.963699f, 237.249756f));
		result.add(new FractalLine(211.312790f, 603.944458f, 185.467499f, 610.782288f));
		result.add(new FractalLine(338.658722f, 339.886658f, 351.092346f, 315.620178f));
		result.add(new FractalLine(454.237976f, 307.718567f, 479.434753f, 318.291595f));
		result.add(new FractalLine(275.959137f, 349.214691f, 288.392792f, 324.948212f));
		result.add(new FractalLine(487.808716f, 562.589111f, 497.739044f, 588.564575f));
		result.add(new FractalLine(272.576385f, 191.564011f, 263.772064f, 166.259827f));
		result.add(new FractalLine(146.591522f, 521.136292f, 120.746239f, 527.974060f));
		result.add(new FractalLine(445.596893f, 347.248474f, 458.030518f, 322.981995f));
		result.add(new FractalLine(239.044357f, 380.442078f, 213.199066f, 387.279785f));
		result.add(new FractalLine(331.969269f, 568.846497f, 336.809235f, 595.080811f));
		result.add(new FractalLine(283.022949f, 455.338379f, 259.823364f, 441.124176f));
		result.add(new FractalLine(334.628784f, 260.932312f, 347.062439f, 236.665833f));
		result.add(new FractalLine(220.323273f, 464.666321f, 197.123718f, 450.452118f));
		result.add(new FractalLine(438.164154f, 441.676270f, 464.762848f, 433.769104f));
		result.add(new FractalLine(400.319061f, 238.228348f, 425.515839f, 248.801361f));
		result.add(new FractalLine(202.723816f, 397.582947f, 215.157455f, 373.316467f));
		result.add(new FractalLine(501.048462f, 474.061371f, 510.978851f, 500.036804f));
		result.add(new FractalLine(295.176727f, 256.888763f, 307.610382f, 232.622299f));
		result.add(new FractalLine(213.303345f, 503.612152f, 190.103790f, 489.397949f));
		result.add(new FractalLine(413.408051f, 409.799500f, 440.006714f, 401.892365f));
		result.add(new FractalLine(390.080353f, 387.745239f, 400.010712f, 413.720673f));
		result.add(new FractalLine(350.708405f, 419.127502f, 377.307068f, 411.220367f));
		result.add(new FractalLine(383.815521f, 571.625671f, 371.679443f, 597.192688f));
		result.add(new FractalLine(330.725372f, 160.564346f, 321.921021f, 135.260178f));
		result.add(new FractalLine(120.165344f, 460.926025f, 94.320068f, 467.763794f));
		result.add(new FractalLine(509.285309f, 368.252197f, 521.718933f, 343.985657f));
		result.add(new FractalLine(212.618225f, 320.231812f, 186.772934f, 327.069550f));
		result.add(new FractalLine(270.055450f, 590.565674f, 274.895416f, 616.799927f));
		result.add(new FractalLine(308.758545f, 393.566772f, 285.558990f, 379.352570f));
		result.add(new FractalLine(398.317261f, 281.936096f, 410.750885f, 257.669617f));
		result.add(new FractalLine(246.058945f, 402.894775f, 222.859375f, 388.680573f));
		result.add(new FractalLine(467.474945f, 503.311462f, 494.073608f, 495.404327f));
		result.add(new FractalLine(290.426605f, 249.241852f, 264.581329f, 256.079590f));
		result.add(new FractalLine(205.334183f, 507.757446f, 210.174164f, 533.991699f));
		result.add(new FractalLine(415.696716f, 400.928497f, 392.497131f, 386.714294f));
		result.add(new FractalLine(297.787048f, 367.063293f, 302.627014f, 393.297546f));
		result.add(new FractalLine(323.120056f, 509.384064f, 349.589569f, 506.561218f));
		result.add(new FractalLine(334.160828f, 489.165222f, 318.256104f, 511.167969f));
		result.add(new FractalLine(304.728607f, 314.612366f, 281.529022f, 300.398163f));
		result.add(new FractalLine(271.461182f, 498.493225f, 255.556442f, 520.495911f));
		result.add(new FractalLine(377.641083f, 457.404663f, 371.794312f, 430.339600f));
		result.add(new FractalLine(344.398376f, 212.445862f, 356.832001f, 188.179382f));
		result.add(new FractalLine(172.823669f, 451.262970f, 149.624115f, 437.048767f));
		result.add(new FractalLine(480.714691f, 414.783691f, 507.313354f, 406.876556f));
		result.add(new FractalLine(265.276550f, 310.568787f, 242.076996f, 296.354584f));
		result.add(new FractalLine(264.441223f, 537.439087f, 248.536499f, 559.441833f));
		result.add(new FractalLine(352.884979f, 425.527863f, 347.038208f, 398.462799f));
		result.add(new FractalLine(369.746552f, 328.467590f, 396.345215f, 320.560425f));
		result.add(new FractalLine(290.185364f, 434.855896f, 284.338593f, 407.790833f));
		result.add(new FractalLine(413.147278f, 514.993347f, 437.663391f, 529.010315f));
		result.add(new FractalLine(378.381470f, 187.762466f, 403.578247f, 198.335464f));
		result.add(new FractalLine(150.846222f, 415.576385f, 163.279861f, 391.309906f));
		result.add(new FractalLine(522.767883f, 422.442749f, 532.698303f, 448.418213f));
		result.add(new FractalLine(243.299133f, 274.882202f, 255.732773f, 250.615738f));
		result.add(new FractalLine(227.265259f, 556.594788f, 204.065735f, 542.380615f));
		result.add(new FractalLine(363.699738f, 384.268677f, 390.298431f, 376.361511f));
		result.add(new FractalLine(411.799774f, 336.126587f, 421.730133f, 362.101990f));
		result.add(new FractalLine(301.000122f, 393.596680f, 327.598846f, 385.689545f));
		result.add(new FractalLine(437.071075f, 551.325806f, 424.934967f, 576.892822f));
		result.add(new FractalLine(321.107483f, 203.892227f, 333.541138f, 179.625748f));
		result.add(new FractalLine(162.544006f, 473.786530f, 139.344482f, 459.572357f));
		result.add(new FractalLine(470.637848f, 391.630402f, 497.236542f, 383.723236f));
		result.add(new FractalLine(254.996902f, 333.092377f, 231.797379f, 318.878174f));
		result.add(new FractalLine(286.070282f, 549.377808f, 270.165588f, 571.380493f));
		result.add(new FractalLine(329.083038f, 433.795074f, 323.236267f, 406.730011f));
		result.add(new FractalLine(359.669769f, 305.314270f, 386.268463f, 297.407104f));
		result.add(new FractalLine(266.383423f, 443.123077f, 260.536652f, 416.058014f));
		result.add(new FractalLine(423.103546f, 491.302307f, 447.619720f, 505.319244f));
		result.add(new FractalLine(357.880859f, 266.636353f, 367.811249f, 292.611786f));
		result.add(new FractalLine(227.764786f, 441.964874f, 254.363449f, 434.057739f));
		result.add(new FractalLine(450.310822f, 462.798004f, 438.174713f, 488.365021f));
		result.add(new FractalLine(320.217682f, 301.270691f, 346.816315f, 293.363556f));
		result.add(new FractalLine(259.363464f, 482.068909f, 253.516693f, 455.003845f));
		result.add(new FractalLine(398.347412f, 459.425507f, 422.863586f, 473.442444f));
		result.add(new FractalLine(339.342712f, 376.481903f, 327.206635f, 402.048920f));
		result.add(new FractalLine(335.647797f, 468.753510f, 360.163971f, 482.770447f));
		result.add(new FractalLine(356.439850f, 526.368530f, 329.093201f, 535.408752f));
		result.add(new FractalLine(370.770905f, 150.766388f, 361.966522f, 125.462212f));
		result.add(new FractalLine(113.458733f, 420.338257f, 87.613449f, 427.176025f));
		result.add(new FractalLine(544.645264f, 390.836182f, 557.078857f, 366.569672f));
		result.add(new FractalLine(205.911636f, 279.644104f, 180.066345f, 286.481842f));
		result.add(new FractalLine(229.163116f, 594.155334f, 234.003159f, 620.389526f));
		result.add(new FractalLine(333.914520f, 360.100861f, 310.714966f, 345.886658f));
		result.add(new FractalLine(433.677094f, 304.520050f, 446.110718f, 280.253571f));
		result.add(new FractalLine(271.214935f, 369.428864f, 248.015411f, 355.214661f));
		result.add(new FractalLine(475.709808f, 545.209167f, 502.308533f, 537.302002f));
		result.add(new FractalLine(283.719971f, 208.654114f, 257.874695f, 215.491852f));
		result.add(new FractalLine(164.441849f, 511.347107f, 169.281876f, 537.581360f));
		result.add(new FractalLine(440.852692f, 367.462616f, 417.653168f, 353.248413f));
		result.add(new FractalLine(256.894714f, 370.652893f, 261.734711f, 396.887177f));
		result.add(new FractalLine(323.585419f, 550.342651f, 350.054962f, 547.519836f));
		result.add(new FractalLine(302.774689f, 461.594116f, 286.869995f, 483.596863f));
		result.add(new FractalLine(329.884583f, 281.146484f, 306.685059f, 266.932281f));
		result.add(new FractalLine(240.075043f, 470.922089f, 224.170303f, 492.924805f));
		result.add(new FractalLine(419.952850f, 452.393890f, 414.106079f, 425.328796f));
		result.add(new FractalLine(379.758179f, 235.029846f, 392.191803f, 210.763367f));
		result.add(new FractalLine(197.979630f, 417.797119f, 174.780090f, 403.582916f));
		result.add(new FractalLine(488.949554f, 456.681396f, 515.548279f, 448.774292f));
		result.add(new FractalLine(290.432526f, 277.102936f, 267.233002f, 262.888733f));
		result.add(new FractalLine(233.055115f, 509.867920f, 217.150375f, 531.870667f));
		result.add(new FractalLine(395.196747f, 420.517120f, 389.349976f, 393.452087f));
		result.add(new FractalLine(377.981445f, 370.365265f, 404.580170f, 362.458160f));
		result.add(new FractalLine(332.497101f, 429.845123f, 326.650330f, 402.780090f));
		result.add(new FractalLine(388.101532f, 550.504761f, 412.617645f, 564.521729f));
		result.add(new FractalLine(341.868958f, 177.654465f, 316.023712f, 184.492218f));
		result.add(new FractalLine(138.015686f, 451.136841f, 142.855698f, 477.371094f));
		result.add(new FractalLine(504.541107f, 388.466400f, 481.341553f, 374.252197f));
		result.add(new FractalLine(230.468567f, 310.442627f, 235.308563f, 336.676880f));
		result.add(new FractalLine(261.671600f, 572.061768f, 288.141083f, 569.239014f));
		result.add(new FractalLine(328.510315f, 399.822540f, 312.605591f, 421.825256f));
		result.add(new FractalLine(393.573029f, 302.150269f, 370.373505f, 287.936096f));
		result.add(new FractalLine(265.810730f, 409.150543f, 249.905975f, 431.153290f));
		result.add(new FractalLine(449.263641f, 514.029114f, 443.416870f, 486.964050f));
		result.add(new FractalLine(308.276947f, 239.452652f, 313.116943f, 265.686920f));
		result.add(new FractalLine(196.950333f, 489.253571f, 223.419846f, 486.430817f));
		result.add(new FractalLine(435.448486f, 407.184265f, 419.543732f, 429.187012f));
		result.add(new FractalLine(289.403198f, 348.559418f, 315.872742f, 345.736664f));
		result.add(new FractalLine(304.072754f, 516.320007f, 303.274841f, 489.769714f));
		result.add(new FractalLine(341.885376f, 469.988342f, 362.568939f, 487.484161f));
		result.add(new FractalLine(324.480377f, 320.868134f, 308.575623f, 342.870880f));
		result.add(new FractalLine(279.185730f, 479.316345f, 299.869263f, 496.812164f));
		result.add(new FractalLine(386.921295f, 476.338135f, 359.548676f, 480.099518f));
		result.add(new FractalLine(339.654144f, 232.660019f, 316.454620f, 218.445816f));
		result.add(new FractalLine(192.575424f, 457.518738f, 176.670700f, 479.521454f));
		result.add(new FractalLine(462.503387f, 425.501312f, 456.656616f, 398.436279f));
		result.add(new FractalLine(285.028320f, 316.824554f, 269.123596f, 338.827271f));
		result.add(new FractalLine(272.165771f, 518.262146f, 292.849335f, 535.757935f));
		result.add(new FractalLine(362.165161f, 444.461334f, 334.792542f, 448.222717f));
		result.add(new FractalLine(351.535278f, 339.185211f, 345.688477f, 312.120148f));
		result.add(new FractalLine(299.465546f, 453.789337f, 272.092957f, 457.550720f));
		result.add(new FractalLine(392.458557f, 509.124603f, 408.267029f, 485.796936f));
		result.add(new FractalLine(357.820587f, 184.563980f, 370.254211f, 160.297485f));
		result.add(new FractalLine(146.102051f, 435.790558f, 122.902489f, 421.576385f));
		result.add(new FractalLine(510.668976f, 405.062775f, 537.267639f, 397.155609f));
		result.add(new FractalLine(238.554947f, 295.096344f, 215.355423f, 280.882141f));
		result.add(new FractalLine(247.017029f, 562.850525f, 231.112320f, 584.853271f));
		result.add(new FractalLine(345.488434f, 394.986298f, 339.641663f, 367.921204f));
		result.add(new FractalLine(399.700867f, 318.746643f, 426.299561f, 310.839508f));
		result.add(new FractalLine(282.788818f, 404.314301f, 276.942078f, 377.249207f));
		result.add(new FractalLine(441.357086f, 530.204895f, 465.873230f, 544.221802f));
		result.add(new FractalLine(316.363281f, 224.106400f, 293.163757f, 209.892181f));
		result.add(new FractalLine(182.295761f, 480.042297f, 166.391022f, 502.044983f));
		result.add(new FractalLine(452.426575f, 402.348022f, 446.579773f, 375.282959f));
		result.add(new FractalLine(274.748657f, 339.348145f, 258.843933f, 361.350830f));
		result.add(new FractalLine(293.794800f, 530.200928f, 314.478333f, 547.696716f));
		result.add(new FractalLine(338.363251f, 452.728546f, 310.990631f, 456.489929f));
		result.add(new FractalLine(341.458466f, 316.031891f, 335.611694f, 288.966797f));
		result.add(new FractalLine(275.663605f, 462.056519f, 248.291016f, 465.817902f));
		result.add(new FractalLine(402.414825f, 485.433563f, 418.223267f, 462.105927f));
		result.add(new FractalLine(345.781952f, 249.256378f, 372.380676f, 241.349258f));
		result.add(new FractalLine(209.553528f, 452.682495f, 203.706757f, 425.617462f));
		result.add(new FractalLine(454.596832f, 441.677094f, 479.112946f, 455.694061f));
		result.add(new FractalLine(302.006409f, 311.988312f, 296.159637f, 284.923279f));
		result.add(new FractalLine(268.643646f, 501.002350f, 241.271057f, 504.763733f));
		result.add(new FractalLine(377.658691f, 453.556763f, 393.467163f, 430.229126f));
		result.add(new FractalLine(343.628723f, 355.360992f, 368.144836f, 369.377930f));
		result.add(new FractalLine(314.959076f, 462.884766f, 330.767517f, 439.557129f));
		result.add(new FractalLine(374.996368f, 514.676208f, 381.913757f, 542.571594f));
		result.add(new FractalLine(372.888611f, 153.776199f, 398.085388f, 164.349182f));
		result.add(new FractalLine(116.614227f, 418.459869f, 129.047852f, 394.193420f));
		result.add(new FractalLine(543.918762f, 394.510406f, 553.849121f, 420.485840f));
		result.add(new FractalLine(209.067139f, 277.765686f, 221.500778f, 253.499207f));
		result.add(new FractalLine(227.533905f, 590.873047f, 204.334335f, 576.658875f));
		result.add(new FractalLine(337.515015f, 361.102753f, 364.113708f, 353.195587f));
		result.add(new FractalLine(432.950623f, 308.194275f, 442.881012f, 334.169678f));
		result.add(new FractalLine(274.815430f, 370.430756f, 301.414093f, 362.523621f));
		result.add(new FractalLine(472.495178f, 547.257202f, 460.359039f, 572.824219f));
		result.add(new FractalLine(286.875488f, 206.775726f, 299.309113f, 182.509262f));
		result.add(new FractalLine(162.812637f, 508.064850f, 139.613083f, 493.850647f));
		result.add(new FractalLine(444.453186f, 368.464508f, 471.051849f, 360.557404f));
		result.add(new FractalLine(255.265518f, 367.370667f, 232.065979f, 353.156433f));
		result.add(new FractalLine(320.195953f, 551.714355f, 304.291199f, 573.717102f));
		result.add(new FractalLine(304.045044f, 458.087921f, 298.198273f, 431.022827f));
		result.add(new FractalLine(333.485077f, 282.148376f, 360.083740f, 274.241241f));
		result.add(new FractalLine(241.345383f, 467.415894f, 235.498642f, 440.350800f));
		result.add(new FractalLine(421.746399f, 455.747925f, 446.262512f, 469.764862f));
		result.add(new FractalLine(379.031738f, 238.704041f, 388.962097f, 264.679474f));
		result.add(new FractalLine(201.580093f, 418.799011f, 228.178772f, 410.891876f));
		result.add(new FractalLine(485.734924f, 458.729462f, 473.598816f, 484.296478f));
		result.add(new FractalLine(294.033020f, 278.104828f, 320.631683f, 270.197693f));
		result.add(new FractalLine(234.325455f, 506.361725f, 228.478714f, 479.296631f));
		result.add(new FractalLine(396.990295f, 423.871155f, 421.506378f, 437.888123f));
		result.add(new FractalLine(374.766815f, 372.413330f, 362.630707f, 397.980347f));
		result.add(new FractalLine(334.290649f, 433.199158f, 358.806732f, 447.216125f));
		result.add(new FractalLine(384.334595f, 549.578613f, 356.987976f, 558.618896f));
		result.add(new FractalLine(345.024475f, 175.776062f, 357.458099f, 151.509583f));
		result.add(new FractalLine(136.386475f, 447.854584f, 113.186920f, 433.640411f));
		result.add(new FractalLine(508.141602f, 389.468292f, 534.740295f, 381.561127f));
		result.add(new FractalLine(228.839355f, 307.160370f, 205.639832f, 292.946136f));
		result.add(new FractalLine(258.282135f, 573.433472f, 242.377426f, 595.436218f));
		result.add(new FractalLine(329.780670f, 396.316345f, 323.933899f, 369.251251f));
		result.add(new FractalLine(397.173523f, 303.152161f, 423.772186f, 295.245026f));
		result.add(new FractalLine(267.081055f, 405.644348f, 261.234314f, 378.579254f));
		result.add(new FractalLine(451.057190f, 517.383118f, 475.573273f, 531.400085f));
		result.add(new FractalLine(306.647736f, 236.170410f, 283.448212f, 221.956192f));
		result.add(new FractalLine(193.560883f, 490.625244f, 177.656143f, 512.627930f));
		result.add(new FractalLine(436.718811f, 403.678070f, 430.872040f, 376.612976f));
		result.add(new FractalLine(286.013763f, 349.931091f, 270.109039f, 371.933807f));
		result.add(new FractalLine(305.180054f, 519.796570f, 325.863586f, 537.292358f));
		result.add(new FractalLine(338.493378f, 468.458069f, 311.120758f, 472.219452f));
		result.add(new FractalLine(325.750702f, 317.361938f, 319.903931f, 290.296844f));
		result.add(new FractalLine(275.793732f, 477.786072f, 248.421127f, 481.547424f));
		result.add(new FractalLine(390.394623f, 474.808441f, 406.203094f, 451.480804f));
		result.add(new FractalLine(343.254639f, 233.661911f, 369.853302f, 225.754776f));
		result.add(new FractalLine(193.845764f, 454.012543f, 187.999023f, 426.947449f));
		result.add(new FractalLine(464.296936f, 428.855347f, 488.813019f, 442.872314f));
		result.add(new FractalLine(286.298676f, 313.318359f, 280.451904f, 286.253265f));
		result.add(new FractalLine(268.773773f, 516.731873f, 241.401154f, 520.493286f));
		result.add(new FractalLine(365.638489f, 442.931641f, 381.446960f, 419.604004f));
		result.add(new FractalLine(353.328796f, 342.539246f, 377.844940f, 356.556152f));
		result.add(new FractalLine(302.938873f, 452.259644f, 318.747314f, 428.932007f));
		result.add(new FractalLine(391.250916f, 512.802185f, 398.168274f, 540.697510f));
		result.add(new FractalLine(357.094116f, 188.238174f, 367.024506f, 214.213608f));
		result.add(new FractalLine(149.702515f, 436.792450f, 176.301178f, 428.885315f));
		result.add(new FractalLine(507.454315f, 407.110840f, 495.318237f, 432.677917f));
		result.add(new FractalLine(242.155411f, 296.098236f, 268.754089f, 288.191132f));
		result.add(new FractalLine(248.287354f, 559.344299f, 242.440582f, 532.279297f));
		result.add(new FractalLine(347.281982f, 398.340332f, 371.798096f, 412.357269f));
		result.add(new FractalLine(396.486237f, 320.794708f, 384.350128f, 346.361725f));
		result.add(new FractalLine(284.582367f, 407.668335f, 309.098511f, 421.685272f));
		result.add(new FractalLine(437.590149f, 529.278687f, 410.243469f, 538.318970f));
		result.add(new FractalLine(319.963776f, 225.108292f, 346.562439f, 217.201157f));
		result.add(new FractalLine(183.566101f, 476.536102f, 177.719360f, 449.471039f));
		result.add(new FractalLine(454.220123f, 405.702057f, 478.736237f, 419.718994f));
		result.add(new FractalLine(276.019012f, 335.841949f, 270.172241f, 308.776886f));
		result.add(new FractalLine(290.402802f, 528.670654f, 263.030212f, 532.432007f));
		result.add(new FractalLine(341.836578f, 451.198853f, 357.645050f, 427.871216f));
		result.add(new FractalLine(343.252014f, 319.385925f, 367.768127f, 333.402863f));
		result.add(new FractalLine(279.136932f, 460.526825f, 294.945374f, 437.199188f));
		result.add(new FractalLine(401.207184f, 489.111115f, 408.124573f, 517.006470f));
		result.add(new FractalLine(342.567322f, 251.304443f, 330.431213f, 276.871490f));
		result.add(new FractalLine(211.347061f, 456.036530f, 235.863174f, 470.053467f));
		result.add(new FractalLine(450.829895f, 440.750946f, 423.483276f, 449.791199f));
		result.add(new FractalLine(303.799927f, 315.342346f, 328.316040f, 329.359283f));
		result.add(new FractalLine(272.116974f, 499.472656f, 287.925415f, 476.145020f));
		result.add(new FractalLine(376.451050f, 457.234314f, 383.368439f, 485.129669f));
		result.add(new FractalLine(339.861786f, 354.434845f, 312.515167f, 363.475128f));
		result.add(new FractalLine(313.751434f, 466.562317f, 320.668823f, 494.457672f));
		result.add(new FractalLine(373.030121f, 511.252960f, 347.154236f, 497.482086f));

		return result;
	}
}

